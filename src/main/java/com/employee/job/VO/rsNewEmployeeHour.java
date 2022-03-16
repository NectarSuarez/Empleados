package com.employee.job.VO;

public class rsNewEmployeeHour
{
	private int id;
	private boolean success;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public rsNewEmployeeHour(int id, boolean success) {
		super();
		this.id = id;
		this.success = success;
	}
	public rsNewEmployeeHour() {
		super();
	}
}
