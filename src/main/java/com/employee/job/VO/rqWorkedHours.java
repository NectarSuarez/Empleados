package com.employee.job.VO;

import java.util.Date;

public class rqWorkedHours
{
	private int employee_id;
	private int worked_hours;
	private Date worked_date;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getWorked_hours() {
		return worked_hours;
	}
	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}
	public Date getWorked_date() {
		return worked_date;
	}
	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}
	public rqWorkedHours(int employee_id, int worked_hours, Date worked_date) {
		super();
		this.employee_id = employee_id;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
	}
	public rqWorkedHours() {
		super();
	}
}
