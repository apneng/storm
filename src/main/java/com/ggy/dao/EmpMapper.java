package com.ggy.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ggy.pojo.Emp;

public interface EmpMapper {

	/**
	 * 获取所有雇员信息
	 * 
	 * @return
	 */
	public List<Map<String, String>> showEmps(@Param(value = "page")int page, @Param(value = "rows")int rows);

	// 删除职员
	public int deleteByEmpId(String empid);

	// 添加职员
	public int addEmp(Emp emp);

	public Emp getEmpByEmpid(String empid);
	//修改职员信息
	public int updateEmp(Emp emp);
//获取total数
	public Integer getCountEmp();

}
