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
	
	public List<Map<String, String>> showEmps(){
		return this.empMapper.showEmps();
		
	}

}
