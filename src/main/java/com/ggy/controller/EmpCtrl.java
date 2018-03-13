package com.ggy.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ggy.Model.BaseResultModel;
import com.ggy.pojo.Emp;
import com.ggy.pojo.User;
import com.ggy.service.EmpService;
import com.ggy.util.MD5;
import com.ggy.util.SysCode;

@Controller
@RequestMapping("empCtrl")
public class EmpCtrl {
	@Autowired
	private EmpService empService;
	
	@ResponseBody
	@RequestMapping("/showEmps")
	public String showEmps(){
		List<Map<String, String>> list = this.empService.showEmps();
//		System.out.println(list.get(0).get("dname"));
		String json = JSON.toJSONString(list);
//		System.out.println(json);
		return json;
	}
//	删除职员
	@ResponseBody
	@RequestMapping("deleteByPrimaryKey")
	public BaseResultModel deleteByPrimaryKey(String empid){
		BaseResultModel model = new BaseResultModel();
		try
		{
			int count = this.empService.deleteByPrimaryKey(empid);
			
			if (count > 0)
			{
				model.setRtnCode(SysCode.RTN_CODE_SUCCESS);
				model.setRtnMsg("删除成功");
		
			}

			if (count <= 0)
			{
				model.setRtnCode(SysCode.RTN_CODE_FAIL);
				model.setRtnMsg("删除失败");
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("删除错误");
		}
		
		return model;
	}
	
//	新增
	@ResponseBody
	@RequestMapping("addEmp")
	public int addEmp(Emp emp){
		return this.empService.addEmp(emp);
	}
//	获取职员信息
	@ResponseBody
	@RequestMapping("getEmpByEmpid")
	public Emp getEmpByEmpid(int empid){
		return this.empService.getEmpByEmpid(empid);
	}
//	修改职员信息
	@ResponseBody
	@RequestMapping("updateEmp")
	public BaseResultModel updateEmp(Emp emp){
		BaseResultModel model = new BaseResultModel();
		try
		{
			int count = this.empService.updateEmp(emp);
			
			if (count > 0)
			{
				model.setRtnCode(SysCode.RTN_CODE_SUCCESS);
				model.setRtnMsg("修改成功");
		
			}

			if (count <= 0)
			{
				model.setRtnCode(SysCode.RTN_CODE_FAIL);
				model.setRtnMsg("修改失败");
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("修改错误");
		}
		
		return model;
		
		
	}
}
