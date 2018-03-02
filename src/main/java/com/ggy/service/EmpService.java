package com.ggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggy.dao.EmpMapper;
import com.ggy.pojo.Emp;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> showEmps(){
		List<Emp> list = this.empMapper.showEmps();
		return list;
		
	}

}
