package com.employee.job.VO;

import java.util.Date;

public class VOEmployees
{
	private int id;
	private String name;
	private String lastName;
	private Date birthdate;
	VOGenders gender;
	VOJobs job;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}	
	
	public VOGenders getGender() {
		return gender;
	}
	public void setGender(VOGenders gender) {
		this.gender = gender;
	}
	public VOJobs getJob() {
		return job;
	}
	public void setJob(VOJobs job) {
		this.job = job;
	}
	
	public VOEmployees(int id, String name, String lastName, Date birthdate, VOGenders gender,
			VOJobs job) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.job = job;
	}
	
	public VOEmployees() {
		super();
		// TODO Auto-generated constructor stub
	}
}
