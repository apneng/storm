package com.ggy.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 职员类
 * 
 * @author apneng 2017年10月26日上午9:53:41
 *
 */
public class Emp extends Dept {
	
	private String empid;
	private String ename;
	private Integer egender;
	
	private Integer eage;
	private String ephone;
	private Date ebirthday;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getEbirthday() {
		return ebirthday;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEbirthday(Date ebirthday) {
		this.ebirthday = ebirthday;
	}

	public String getEmpid() {
		return empid;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public void setEmpid(String empid) {
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
	}
	


	public Emp() {
	}

	public Emp(String empid, String ename, Integer egender, Integer eage, String ephone, Integer deptid) {
	
		this.empid = empid;
		this.ename = ename;
		this.egender = egender;
		this.eage = eage;
		this.ephone = ephone;
	}

}
