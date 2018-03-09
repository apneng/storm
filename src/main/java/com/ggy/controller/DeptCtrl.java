package com.ggy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ggy.service.DeptService;

@Controller
@RequestMapping("deptCtrl")
public class DeptCtrl {
	@Autowired
	private DeptService deptService;
	@ResponseBody
	@RequestMapping("/showDept")
	public String showDept(){
		List<Map<String, String>> list = this.deptService.showDept();
		String json = JSON.toJSONString(list);
		return json;
	}
}
