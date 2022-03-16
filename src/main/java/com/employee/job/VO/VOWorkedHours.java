package com.employee.job.VO;

import java.util.Date;

public class VOWorkedHours
{
	private int id;
	private int employeeId;
	private int workedHours;
	private Date workedDate;
	VOEmployees employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getWorkedHours() {
		return workedHours;
	}
	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}
	public Date getWorkedDate() {
		return workedDate;
	}
	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}
	
	public VOEmployees getEmployee() {
		return employee;
	}
	public void setEmployee(VOEmployees employee) {
		this.employee = employee;
	}
	
	public VOWorkedHours(int id, int employeeId, int workedHours, Date workedDate, VOEmployees employee) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.workedHours = workedHours;
		this.workedDate = workedDate;
		this.employee = employee;
	}
	public VOWorkedHours() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
