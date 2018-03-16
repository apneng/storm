package com.ggy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggy.dao.EmpMapper;
import com.ggy.pojo.Emp;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empMapper;
	
	public List<Map<String, String>> showEmps(int page, int rows){
		return this.empMapper.showEmps(page,rows);
		
	}
//删除职员
	public int deleteByPrimaryKey(String empid) {
		// TODO Auto-generated method stub
		return this.empMapper.deleteByEmpId(empid);
	}
	public int addEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.addEmp(emp);
	}
	public Emp getEmpByEmpid(String empid) {
		// TODO Auto-generated method stub
		return empMapper.getEmpByEmpid(empid);
	}
//	修改职员信息
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.updateEmp(emp);
	}
	public Integer getCountEmp() {
		// TODO Auto-generated method stub
		return empMapper.getCountEmp();
	}
	public List<Map<String, String>> showEmpsWithNoPage() {
		// TODO Auto-generated method stub
		return this.empMapper.showEmpsWithNoPage();
	}

}
