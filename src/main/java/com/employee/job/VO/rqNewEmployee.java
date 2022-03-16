package com.employee.job.VO;

import java.util.Date;

public class rqNewEmployee
{
    private int gender_id;
    private int job_id;
    private String name;
    private String last_name;
    private Date birthdate;
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public rqNewEmployee(int gender_id, int job_id, String name, String last_name, Date birthdate) {
		super();
		this.gender_id = gender_id;
		this.job_id = job_id;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
	}
	public rqNewEmployee() {
		super();
	}
}
