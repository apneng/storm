package com.ggy.pojo;

import java.io.Serializable;

public class Dept implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dname;


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
