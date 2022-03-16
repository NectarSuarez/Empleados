package com.employee.job.VO;

import java.util.Date;

public class rqGetWorkedHoursPayment
{
	private int employee_id;
	private Date start_date;
	private Date end_date;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public rqGetWorkedHoursPayment(int employee_id, Date start_date, Date end_date) {
		super();
		this.employee_id = employee_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public rqGetWorkedHoursPayment() {
		super();
	}
}
