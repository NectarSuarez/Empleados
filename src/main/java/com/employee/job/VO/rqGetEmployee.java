package com.employee.job.VO;

public class rqGetEmployee
{
	private int job_id;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public rqGetEmployee(int job_id) {
		super();
		this.job_id = job_id;
	}

	public rqGetEmployee() {
		super();
	}
}
