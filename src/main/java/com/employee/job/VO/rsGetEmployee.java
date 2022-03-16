package com.employee.job.VO;

import java.util.List;

public class rsGetEmployee
{
	private List<VOEmployees> EmployeeList;
	private Boolean Success;
	public List<VOEmployees> getEmployeeList() {
		return EmployeeList;
	}
	public void setEmployeeList(List<VOEmployees> employeeList) {
		EmployeeList = employeeList;
	}
	public Boolean getSuccess() {
		return Success;
	}
	public void setSuccess(Boolean success) {
		Success = success;
	}
	public rsGetEmployee(List<VOEmployees> employeeList, Boolean success) {
		super();
		EmployeeList = employeeList;
		Success = success;
	}
	public rsGetEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
