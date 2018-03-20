//package com.ggy.controller;
//
//import java.io.InputStream;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.dom4j.Document;
//import org.dom4j.Element;
//import org.dom4j.Node;
//import org.dom4j.io.SAXReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.ggy.Model.BaseResultModel;
//import com.ggy.pojo.Emp;
//import com.ggy.pojo.User;
//import com.ggy.service.EmpService;
//import com.ggy.service.ImportService;
//import com.ggy.util.SysCode;
//
//
//
//@Controller
//@RequestMapping("import")
//public class ImportCtrl
//{
//	@Autowired
//	private ImportService importService;
//	@Autowired
//	private EmpService empService;
//
//
//	private static String TABLE_T_ALU_ALUMNI = "T_ALU_ALUMNI";
//
//	private static Map<String, String> sqlMap = new HashMap<String, String>();
//
//	static
//	{
//		sqlMap.put("T_ALU_ALUMNI", "( select " + "  t.*,  " + "  (select WMSYS.WM_CONCAT(name) from t_alu_tag where id in (select tag_id from t_alu_tag_rel where alu_id = t.id)) ALU_TAG " + "  from T_ALU_ALUMNI t )");
//	}
//
//	/**
//	 * 单表导入
//	 * 
//	 * @param tableName 表名称
//	 * @param columnNames 列名称，如果从export.xml配置文件读取,则不需要传递该参数
//	 * @param userId session中无法获取user，所以从页面获取
//	 * @param orgId session中无法获取user，所以从页面获取
//	 * @param request
//	 * @return
//	 * @throws Throwable
//	 */
//	@ResponseBody
//	@RequestMapping("ipt")
//	public BaseResultModel ipt(String importType, String tableName, String[] columnNames, String userId, String orgId, HttpServletRequest request) throws Throwable
//	{
//		BaseResultModel model = new BaseResultModel();
//
//		Workbook wb = null;
//
//		if (ServletFileUpload.isMultipartContent(request))
//		{
//			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//			for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet())
//			{
//				MultipartFile mf = entity.getValue();
//				String fileName = mf.getOriginalFilename();
//				InputStream input = mf.getInputStream();
//				if (fileName.endsWith(".xls"))
//				{
//					wb = new HSSFWorkbook(input);
//				}
//				else if (fileName.endsWith(".xlsx"))
//				{
//					wb = new XSSFWorkbook(input);
//				}
//				else
//				{
//					throw new Exception();
//				}
//			}
//		}
//
//		// 读取配置文件
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(ImportCtrl.class.getClassLoader().getResourceAsStream("com/ggy/config/import.xml"));
//		Element root = document.getRootElement(); // 获取根节点
//
//		Node sheet = root.selectSingleNode("//sheet[@table='" + tableName + "']");
//
//		List<RowConfig> rows = new ArrayList<RowConfig>();
//		int sheetIndex = 0;
//		// 没有相关配置信息,采用默认配置信息.
//		if (sheet == null)
//		{
//			RowConfig row = new RowConfig();
//			row.setFrom(1);
//
//			//根据formId,获取字段信息
//			int idx = 0;
//
//			//
//			for (String columnName : columnNames)
//			{
//				ColConfig colConfig = new ColConfig();
//				colConfig.setCol(idx);
//				colConfig.setName(columnName);
//				idx++;
//				row.addCol(colConfig);
//			}
//
//			//
//			rows.add(row);
//		}
//		//按import.xml配置文件导入
//		else
//		{
//			if (sheet.selectSingleNode("@t_name") != null)
//			{
//				tableName = sheet.selectSingleNode("@t_name").getStringValue();
//			}
//
//			sheetIndex = Integer.parseInt(sheet.selectSingleNode("@idx").getStringValue());
//			List<Element> rowNodes = sheet.selectNodes("rows"); //遍历rows节点
//
//			for (Element row : rowNodes)
//			{
//				RowConfig rowConfig = new RowConfig();
//				int from = 0, to = 0;
//				from = row.selectSingleNode("@from") == null ? 0 : Integer.parseInt(row.selectSingleNode("@from").getStringValue());
//				to = row.selectSingleNode("@to") == null ? 0 : Integer.parseInt(row.selectSingleNode("@to").getStringValue());
//				rowConfig.setFrom(from);
//				rowConfig.setTo(to);
//				List<Element> cellNodes = row.selectNodes("cell"); //遍历cell节点
//
//				for (Element cell : cellNodes)
//				{
//					ColConfig colConfig = new ColConfig();
//					String name = cell.selectSingleNode("@name") == null ? "" : cell.selectSingleNode("@name").getStringValue();
//					int col = cell.selectSingleNode("@col") == null ? 0 : Integer.parseInt(cell.selectSingleNode("@col").getStringValue());
//
//					colConfig.setCol(col);
//					colConfig.setName(name);
//					rowConfig.addCol(colConfig);
//				}
//
//				rows.add(rowConfig);
//			}
//		}
//
//		Sheet sheetVal = wb.getSheetAt(sheetIndex);
//
//		String msg = null;
//		try
//		{
//			this.importService.importBatch(importType, columnNames, rows, sheetVal, tableName, userId, orgId);
//		}
//		catch (ImportService.ImportException ex)
//		{
//			msg = ex.getMsg();
//			ex.printStackTrace();
//		}
//		catch (Exception e)
//		{
//			msg = e.getLocalizedMessage();
//			e.printStackTrace();
//		}
//		if (null != msg && !"".equals(msg))
//		{
//			model.setRtnCode(SysCode.RTN_CODE_FAIL);
//			model.setErrorMsg(msg);
//		}
//
//		return model;
//	}
//
//	public class RowConfig
//	{
//		private int from;
//		private int to;
//		private List<ColConfig> cols = new ArrayList<ColConfig>();
//
//		public int getFrom()
//		{
//			return from;
//		}
//
//		public void setFrom(int from)
//		{
//			this.from = from;
//		}
//
//		public List<ColConfig> getCols()
//		{
//			return cols;
//		}
//
//		public void setCols(List<ColConfig> cols)
//		{
//			this.cols = cols;
//		}
//
//		public int getTo()
//		{
//			return to;
//		}
//
//		public void setTo(int to)
//		{
//			this.to = to;
//		}
//
//		public void addCol(ColConfig col)
//		{
//			this.cols.add(col);
//		}
//	}
//
//	public class ColConfig
//	{
//		private String name;
//		private int col;
//
//		public String getName()
//		{
//			return name;
//		}
//
//		public void setName(String name)
//		{
//			this.name = name;
//		}
//
//		public int getCol()
//		{
//			return col;
//		}
//
//		public void setCol(int col)
//		{
//			this.col = col;
//		}
//	}
//
//	/**
//	 * 读取excel里单元格的值
//	 */
//	public Object getCellValue(Cell cell)
//	{
//		Object value = null;
//
//		if (cell == null)
//		{
//			return null;
//		}
//
//		switch (cell.getCellType())
//		{
//			case HSSFCell.CELL_TYPE_NUMERIC:
//				if (HSSFDateUtil.isCellDateFormatted(cell))
//				{ // 判断是日期类型
//					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
//					Date dt = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());// 获取成DATE类型
//					value = dateformat.format(dt);
//				}
//				else
//				{
//					DecimalFormat df = new DecimalFormat("0.0000");
//					value = df.format(cell.getNumericCellValue());
//				}
//
//				break;
//			case HSSFCell.CELL_TYPE_STRING:
//				value = cell.getStringCellValue().trim();
//				break;
//			case HSSFCell.CELL_TYPE_BOOLEAN:
//				value = cell.getBooleanCellValue();
//				break;
//			case HSSFCell.CELL_TYPE_FORMULA:
//				try
//				{
//					value = String.valueOf(cell.getNumericCellValue());
//				}
//				catch (IllegalStateException e)
//				{
//					value = String.valueOf(cell.getRichStringCellValue());
//				}
//				break;
//			case HSSFCell.CELL_TYPE_BLANK:
//				value = null;
//				break;
//			default:
//				value = cell.getStringCellValue().trim();
//				break;
//		}
//		return value;
//
//	}
//
//	/**
//	 * 判断一个字符串数组里是否包含某个字符串
//	 */
//	private boolean contains(String[] array, String value)
//	{
//		for (int i = 0; i < array.length; i++)
//		{
//			if (value.equals(array[i]))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * @desc 单表导出
//	 * @param tableName 表名
//	 * @param response
//	 * @throws Throwable
//	 */
//	@ResponseBody
//	@RequestMapping("export")
//	public void export(String tableName, Emp vo, String colname, String keywordForExport, HttpServletRequest request, HttpServletResponse response) throws Throwable
//	{
//
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("loginUser");
//		String userId = user.getId();
////		String orgId = user.getOrgId();
//		String formId = request.getParameter("formId");//获取客户端传入表单ID，用以查询自定义表名以及表字段 ZENGWENFENG
//		
//		if (formId == null || formId.trim().equals(""))
//		{
//			throw new Throwable("客户端传入表单ID为空！");
//		}
//
//		response.setContentType("application/x-download");
//
//		// 读取配置文件
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(ImportCtrl.class.getClassLoader()
//				.getResourceAsStream("com/ggy/config/export.xml"));
//
//		Element root = document.getRootElement(); // 获取根节点
//		List<Node> ls = root.selectNodes("sheet[@table='" + tableName + "']"); // 查询需要导出的表的配置信息
//		int from = 0;
//		// 获取字段名
//		Iterator it = ls.iterator();
//		// 读取模板
//		HSSFWorkbook wb = null;//zengwenfeng
//		String name = "";
//		if (ls != null && ls.size() > 0) {
//			Node sheet = ls.get(0);
//			name = sheet.selectSingleNode("@name").getText();
//			String tempName = sheet.selectSingleNode("@template").getText();
//			if (StringUtils.isEmpty(tempName)) {
//				tempName = sheet.selectSingleNode("@table").getText();
//			}
//			wb = new HSSFWorkbook(ImportCtrl.class.getClassLoader()
//					.getResourceAsStream(
//							"com/lz/sys/template/" + tempName + ".xls"));
//		} else {/*
////			return;
//			//----------------------------------------------------------------------------------------
//			//如果没有在配置文件com/lz/sys/config/export.xml配置固定模板，将生成临时模板，导出数据
//			//zengwenfeng
//			//----------------------------------------------------------------------------------------
//			//创建XLS文件
//			wb = new HSSFWorkbook();
//			
//			//查询表名，作为XLS文件文件名
//			//SELECT * FROM t_fb_form WHERE id = 'f5f02912-8458-4976-9933-81f9b32bb0a3'
//			FormVo form = this.formBuilderService.getFormById(formId);
//			if (form == null)
//			{
//				wb.close();
//				throw new Throwable("数据库表不存在。");
//			}
//			
//			name = form.getTableName();//DEMO_3_ZengWenFeng_2017 这里可能有小写
//			if (name == null || name.trim().equals(""))
//			{
//				wb.close();
//				throw new Throwable("数据库表不存在。");
//			}
//			
//			//查询表中自定义字段，作为XLS文件的列名
//			//SELECT * FROM t_fb_form WHERE id = 'f5f02912-8458-4976-9933-81f9b32bb0a3'
//			//SELECT * FROM t_fb_widget WHERE form_id = 'f5f02912-8458-4976-9933-81f9b32bb0a3';
//			List<FbWidget> listFbWidget = this.fbWidgetService.selectByFormId(formId);
//			
//			//创建XLS临时模板
//			createTemplate(wb, form, listFbWidget);
//			
//			//获取表DEMO_3_ZengWenFeng_2017导出的字段（不是所有字段，界面显示需要导出的字段）
//			List<String> listColumn = new ArrayList<String>();
//			FbWidget curFbWidget = null;
//			for (int i = 0; i < listFbWidget.size(); i++)
//			{
//				curFbWidget = listFbWidget.get(i);
//				
//				if (curFbWidget == null)
//				{
//					continue;
//				}
//				
//				listColumn.add(curFbWidget.getColname());
//			}
//			
//			// 查询数据库表，获取数据// SELECT * FROM DEMO_3_ZengWenFeng_2017
//			List<Map<String, Object>> datas = this.importService.getTableData(name, listColumn, orgId, userId, disId, userType);
//
//			// 存在数据，进行写入excel临时文件
//			if (datas != null && datas.size() > 0)
//			{
//				// 写入excel文件
//				Sheet sheet0 = wb.getSheetAt(0);
//				int lastRowNum = sheet0.getLastRowNum();//获取已经多少行了
//				from = lastRowNum + 1;//从第几行写入
//				Row row = null;//XLS行对象
//				Cell c = null;//XLS列对象
//				for (int i = 0; i < datas.size(); i++)
//				{
//					try
//					{
//						Map<String, Object> data = datas.get(i);
//						
//						if (sheet0.getRow(from) != null)
//						{
//							row = sheet0.getRow(from);
//						}
//						else
//						{
//							row = sheet0.createRow(from);
//						}
//	
//						for (int j = 0; j < listColumn.size(); j++)
//						{
//							if (row.getCell(j) != null)
//							{
//								c = row.getCell(j);
//							}
//							else
//							{
//								c = row.createCell(j);
//							}
//	
//							Object val = data.get(listColumn.get(j).toUpperCase());
//	
//							if (val != null)
//							{
//								c.setCellValue(val.toString());
//							}
//						}
//	
//						from++;
//					}
//					catch (Exception ex)
//					{
//						ex.printStackTrace();
//						Logger.error("导出第" + (i + 1) + "行数据出错!");
//						throw new Throwable(ex);
//					}
//				}
//			}
//			
//			// 修改导出excel文件名为存放汉字的字段name，而不是数据库表名tableName
//			name = form.getName();
//			
//			//----------------------------------------------------------------------------------------
//		*/}
//
//		while (it.hasNext()) {
//			Node sheet = (Node) it.next();
//			List<String> colNames = new ArrayList();
//			Sheet st = wb.getSheetAt(0);
//			String tName = sheet.selectSingleNode("@t_name") == null ? sheet
//					.selectSingleNode("@table").getText() : sheet
//					.selectSingleNode("@t_name").getText();
//			Node fNode = sheet.selectSingleNode("rows/@from");
//			if (fNode != null) {
//				from = Integer.parseInt(fNode.getText());
//			}
//			List<Node> cells = sheet.selectNodes("rows/cell");
//			for (int j = 0; j < cells.size(); j++) {
//				Node cell = cells.get(j);
//				colNames.add(cell.selectSingleNode("@name").getText());
//			}
//			// 获取数据
//			List<Map<String, String>> datas;
//
//			datas = this.empService.showEmpsWithNoPage();
//			/*
//			 * List<Map> datas = this.exportService.getTableData(tName,
//			 * colNames,phaseId, objId);
//			 */
//			// 写入excel文件
//
//			for (int idx = 0; idx < datas.size(); idx++) {
//				try {
//					Map data = datas.get(idx);
//					Row row = null;
//					if (st.getRow(from) != null) {
//						row = st.getRow(from);
//					} else {
//						row = st.createRow(from);
//					}
//					int col = 0;
//					for (int j = 0; j < cells.size(); j++) {
//						Node cell = cells.get(j);
//						String colName = cell.selectSingleNode("@name")
//								.getText();
//						String colStr = cell.selectSingleNode("@col") == null ? ""
//								: cell.selectSingleNode("@col").getText();
//						if (!StringUtils.isEmpty(colStr)) {
//							col = Integer.parseInt(colStr);
//						}
//						Cell c = null;
//						if (row.getCell(col) != null) {
//							c = row.getCell(col);
//						} else {
//							c = row.createCell(col);
//						}
//						col++;
//						Object val = data.get(colName.toUpperCase());
//						if (val != null) {
//							c.setCellValue(val.toString());
//						}
//					}
//					from++;
//				} catch (Exception ex) {
//					ex.printStackTrace();
//					//Logger.error("导出第" + (idx + 1) + "行数据出错!");
//					throw new Throwable(ex);
//				}
//			}
//
//		}
//		response.setHeader("Content-Disposition", "attachment; filename="
//				+ (new String(name.getBytes("GBK"), "iso-8859-1")) + ".xls");
//		wb.write(response.getOutputStream());
//		wb.close();//ZENGWENFENG
//	}
//
//	/**
//	 * 下载模板
//	 * 
//	 * @param tableName表名称
//	 * @param request
//	 * @param response
//	 * @throws Throwable
//	 */
//	@ResponseBody
//	@RequestMapping("download")
//	public void download(String tableName, HttpServletRequest request, HttpServletResponse response) throws Throwable
//	{
//		response.setContentType("binary/octet-stream");
//		// 读取配置文件
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(ImportCtrl.class.getClassLoader().getResourceAsStream("com/lz/sys/config/export.xml"));
//		Element root = document.getRootElement(); // 获取根节点
//		List<Node> ls = root.selectNodes("sheet[@table='" + tableName + "']"); // 查询需要导出的表的配置信息
//		// 读取模板
//		HSSFWorkbook wb = null;
//		String name = "";
//		if (ls != null && ls.size() > 0)
//		{
//			Node sheet = ls.get(0);
//			name = sheet.selectSingleNode("@name").getText();
//			String tempName = sheet.selectSingleNode("@template").getText();
//			if (StringUtils.isEmpty(tempName))
//			{
//				tempName = sheet.selectSingleNode("@table").getText();
//			}
//			wb = new HSSFWorkbook(ImportCtrl.class.getClassLoader().getResourceAsStream("com/lz/sys/template/" + tempName + ".xls"));
//		}
//		response.setHeader("Content-Disposition", "attachment; filename=" + (new String(name.getBytes("GBK"), "iso-8859-1")) + ".xls");
//		wb.write(response.getOutputStream());
//	}
//
//}
