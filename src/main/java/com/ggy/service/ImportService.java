//package com.ggy.service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.springframework.util.StringUtils;
//
//import com.ggy.controller.ImportCtrl.RowConfig;
//
//
//public class ImportService {
//
//	public void importBatch(String importType, String[] columnNames, List<RowConfig> rows, Sheet sheetVal,
//			String tableName, String userId, String orgId) {
//		
//		int batchCount = 100;
//		try {
//			batchCount = Integer.valueOf(InitProperties.getPro("sys.import.batch.count"));
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		
//		int seq = 0 ;
//		this.importMapper.deleteAll(tableName,userId); //先删除旧数据
//		
//		//字段信息
//		List<FbWidget> widgetList = fbWidgetMapper.selectByFormId(formId);
//		if(null == widgetList || widgetList.size() == 0){
//			return;
//		}
//		Map<String,FbWidget> widgetMap = new HashMap<String, FbWidget>();
//		for(int i=0;i<widgetList.size();i++){
//			FbWidget vo = widgetList.get(i);
//			if(null != vo.getColname() && !"".equals(vo.getColname())){
//				widgetMap.put(vo.getColname().toUpperCase(), vo);
//			}
//		}
//		
//		List<List<CellMeta>> rowDatas = new ArrayList<List<CellMeta>>(); //各行数据
//		
//		for (int i = 0; i < rows.size(); i++) { //xml的rows节点数,对于各行字段有不一样时需要配置多个rows节点
//			RowConfig row = rows.get(i);
//			
//			int from = row.getFrom(); // 从第几行开始
//			int to = row.getTo();// 到第几行结束
//			if(to == 0){
//				to = sheetVal.getLastRowNum();
//			}
//			List<ColConfig> cells = row.getCols();// 对应配置文件中的单元格描述
//			
//			while (from <= to) { //遍历每一行
//				
//				List<CellMeta> rowData = new ArrayList<CellMeta>();
//				
//				boolean isEmptyRow = true;
//				for (int j = 0; j < cells.size(); j++) { // 遍历每一列
//					ColConfig cell = cells.get(j);
//					String colName = cell.getName();
//					int colIndex = cell.getCol();
//					FbWidget widget = widgetMap.get(colName.toUpperCase());
//					String format = "yyyy-MM-dd";
//					if(!StringUtils.isEmpty(widget.getType()) && widget.getType().equals("date")){	//日期类型需要获取其格式
//						List<FbWidgetAttr> attrs = this.fbWidgetAttrMapper.getAttrsByWidgetId(widget.getId());
//						for(FbWidgetAttr attr : attrs){
//							if(!StringUtils.isEmpty(attr.getName()) && attr.getName().equals("format")){
//								format = attr.getValue();
//							}
//						}
//					}
//					Object cellValue = this.getCellValue(sheetVal.getRow(from).getCell(colIndex),format); //当前单元格内容
//					CellMeta cellMeta = new CellMeta();
//					cellMeta.setCol(colIndex);
//					cellMeta.setColName(colName);
//					cellMeta.setValue(cellValue);
//					
//					if(!StringUtils.isEmpty(cellValue)){
//						isEmptyRow = false;
//					}
//					
//					rowData.add(cellMeta);
//					
//				} // 遍历每一列 结束
//				
//				if(isEmptyRow){ //空行，不校验，不导入
//					from++;
//					continue; 
//				}
//				
//				CellMeta cellMeta = new CellMeta();
//				cellMeta.setColName("ID");
//				cellMeta.setValue(Tools.getUUID());
//				
//				CellMeta userCellMeta = new CellMeta();
//				userCellMeta.setColName("USER_ID");
//				userCellMeta.setValue(userId);
//				
//				CellMeta orgCellMeta = new CellMeta();
//				orgCellMeta.setColName("ORG_ID");
//				orgCellMeta.setValue(orgId);
//				
//				CellMeta seqCellMeta = new CellMeta();
//				seqCellMeta.setColName("SEQ");
//				seqCellMeta.setValue(seq);
//				seq ++ ;
//				
//				rowData.add(cellMeta);
//				rowData.add(userCellMeta);
//				rowData.add(orgCellMeta);
//				rowData.add(seqCellMeta);
//				
//				rowDatas.add(rowData);
//				
//				if(rowDatas.size() == batchCount){
//					List<CellMeta> ls = rowDatas.get(0);
//					String[] colNameArray = new String[ls.size()];
//					for (int k = 0; k < ls.size(); k++) {
//						colNameArray[k] = ls.get(k).getColName();
//					}
//					this.importMapper.ipt(tableName, colNameArray, rowDatas);
//					
//					rowDatas.clear(); 
//				}
//					
//				from++;
//				
//			} // 遍历每一行 结束
//		}
//		
//		//导入剩余的不足batchCount的部分
//		if(rowDatas.size()>0){
//			List<CellMeta> ls = rowDatas.get(0);
//			String[] colNameArray = new String[ls.size()];
//			for (int k = 0; k < ls.size(); k++) {
//				colNameArray[k] = ls.get(k).getColName();
//			}
//			this.importMapper.ipt(tableName, colNameArray, rowDatas);
//		}
//	}
//	public class ImportException extends RuntimeException
//	{
//		private static final long serialVersionUID = 1L;
//		public String msg = "";
//
//		public ImportException(String msg)
//		{
//			this.msg = msg;
//		}
//
//		public String getMsg()
//		{
//			return msg;
//		}
//
//		public void setMsg(String msg)
//		{
//			this.msg = msg;
//		}
//
//	}
//
//}
