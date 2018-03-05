package com.ggy.pojo;

import java.io.Serializable;

public class Dept implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer deptid;
	private String dname;


	public Integer getDeptid() {
		return deptid;
	}


	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}



	@Override
	public String toString() {
		return "Dept [dname=" + dname + "]";
	}



}
