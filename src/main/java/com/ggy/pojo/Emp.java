package com.ggy.pojo;

import java.io.Serializable;

/**
 * 职员类
 * 
 * @author apneng 2017年10月26日上午9:53:41
 *
 */
public class Emp implements Serializable {
	
	private Integer empid;
	private String ename;
	private Integer egender;
	private Integer eage;
	private String ephone;
	private Integer deptid;

	public Integer getEmpid() {
		return empid;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getEgender() {
		return egender;
	}

	public void setEgender(Integer egender) {
		this.egender = egender;
	}

	public String getEphone() {
		return ephone;
	}

	public void setEphone(String ephone) {
		this.ephone = ephone;
	}


	public Emp(String ename, Integer egender, String ephone, Integer deptid) {
		this.ename = ename;
		this.egender = egender;
		this.ephone = ephone;
		this.deptid = deptid;
	}
	

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", ename=" + ename + ", egender=" + egender + ", eage=" + eage + ", ephone="
				+ ephone + ", deptid=" + deptid + "]";
	}

	public Emp() {
	}

	public Emp(Integer empid, String ename, Integer egender, Integer eage, String ephone, Integer deptid) {
	
		this.empid = empid;
		this.ename = ename;
		this.egender = egender;
		this.eage = eage;
		this.ephone = ephone;
		this.deptid = deptid;
	}

}
