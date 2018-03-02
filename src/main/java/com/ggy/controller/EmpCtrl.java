package com.ggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ggy.pojo.Emp;
import com.ggy.service.EmpService;

@Controller
@RequestMapping("empCtrl")
public class EmpCtrl {
	@Autowired
	private EmpService empService;
	
	@ResponseBody
	@RequestMapping("/showEmps")
	public String showEmps(){
		List<Emp> list = this.empService.showEmps();
		String json = JSON.toJSONString(list);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("/new")
	public String newone(){
		
		return "new";
	}
	@RequestMapping("/list")
	public String list(){
		
		return "list";
	}
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
}
