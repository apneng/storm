package com.ggy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggy.dao.DeptMapper;
import com.ggy.dao.EmpMapper;
@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;

	public List<Map<String, String>> showDept() {
		// TODO Auto-generated method stub
		return this.deptMapper.showDept();
	}

	public int getDeptIdByDname(String dname) {
		// TODO Auto-generated method stub
		return this.deptMapper.getDeptIdByDname(dname);
	}

}
