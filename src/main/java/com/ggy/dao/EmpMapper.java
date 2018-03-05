package com.ggy.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ggy.pojo.Emp;

public interface EmpMapper {

	/**获取所有雇员信息
	 * @return
	 */
	public List<Map<String, String>> showEmps();

	
}
