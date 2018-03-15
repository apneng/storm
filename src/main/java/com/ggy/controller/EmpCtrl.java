package com.ggy.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggy.Model.BaseResultModel;
import com.ggy.pojo.Emp;
import com.ggy.service.EmpService;
import com.ggy.util.Grid;
import com.ggy.util.SysCode;

@Controller
@RequestMapping("empCtrl")
public class EmpCtrl {
	@Autowired
	private EmpService empService;
	
	@ResponseBody
	@RequestMapping("/showEmps")
	public Grid showEmps(int page,int rows){
		//获取全部数据
		int a = (page-1)*rows;
		List<Map<String, String>> list = this.empService.showEmps(a,rows);
		int total = this.empService.getCountEmp();
		Grid grid = new Grid();
		grid.setRows(list);
		grid.setTotal((long) total);//获取total数
//		String json = JSON.toJSONString(list);
		
		System.out.println(grid.toString());
		return grid;
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
	public BaseResultModel addEmp(Emp emp){
		BaseResultModel model = new BaseResultModel();
		emp.setEmpid(UUID.randomUUID().toString().replace("-", ""));
		try
		{
			int count = this.empService.addEmp(emp);
			
			if (count > 0)
			{
				model.setRtnCode(SysCode.RTN_CODE_SUCCESS);
				model.setRtnMsg("添加成功");
		
			}

			if (count <= 0)
			{
				model.setRtnCode(SysCode.RTN_CODE_FAIL);
				model.setRtnMsg("添加失败");
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("添加错误");
		}
		
		return model;
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
