package com.ggy.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.ggy.Model.BaseResultModel;
import com.ggy.service.EmpService;
import com.ggy.util.ExcelUtil;

@Controller
@RequestMapping("importCtrl")
public class ImportCtrl {
	@Autowired
	private EmpService empService;
	//导出
	@ResponseBody
	@RequestMapping("/outport")
	public BaseResultModel outport(HttpServletResponse response){
		BaseResultModel model = new BaseResultModel();
		JSONArray ja =new JSONArray();
		List<Map<String, String>> li = this.empService.showEmpsWithNoPage();//获取业务数据集
		for (Object object : li) {
            ja.add(object);
        }
		System.out.println(ja);
		Map<String,String> headMap = new HashMap<String,String>(); //获取属性-列头
		headMap.put("ename", "姓名");
		headMap.put("egender", "性别");
		headMap.put("eage", "年龄");
		headMap.put("empid", "职员编号");
		headMap.put("dname", "部门");
		headMap.put("ebirthday", "出生日期");
		headMap.put("ephone", "电话号码");
        String title = "职员表";
        ExcelUtil.downloadExcelFile(title,headMap,ja,response);
		return model;
	}
	
}
