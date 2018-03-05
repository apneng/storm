package com.ggy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ggy.service.EmpService;

@Controller
@RequestMapping("empCtrl")
public class EmpCtrl {
	@Autowired
	private EmpService empService;
	
	@ResponseBody
	@RequestMapping("/showEmps")
	public String showEmps(){
		List<Map<String, String>> list = this.empService.showEmps();
		System.out.println(list.get(0).get("dname"));
		String json = JSON.toJSONString(list);
		System.out.println(json);
		return json;
	}
	
}
