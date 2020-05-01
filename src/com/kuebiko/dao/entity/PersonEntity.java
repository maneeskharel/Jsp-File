package com.kuebiko.dao.entity;

import java.sql.Timestamp;
import java.util.Date;

public class PersonEntity {
	private int pid;
	private String userid;
	private String name;
	private String email;
	private Date dob;
	private long mobile;
	private double salary;
	private int ssn;
	private Timestamp createdate;
	private Timestamp updatedate;
	
	public PersonEntity() 
	{
		
	}
	
	public PersonEntity(int pid, String userid, String name, String email, Date dob, long mobile, double salary,
			int ssn, Timestamp createdate, Timestamp updatedate) {
		this.userid=userid;
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.mobile = mobile;
		this.salary = salary;
		this.ssn = ssn;
		this.createdate = createdate;
		this.updatedate = updatedate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "PersonEntity [pid=" + pid + ", userid=" + userid + ", name=" + name + ", email=" + email + ", dob="
				+ dob + ", mobile=" + mobile + ", salary=" + salary + ", ssn=" + ssn + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + "]";
	}

}
