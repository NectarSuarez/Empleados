package com.employee.job.VO;

public class rsPayment
{
	private int payment;
	private boolean success;
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public rsPayment(int payment, boolean success) {
		super();
		this.payment = payment;
		this.success = success;
	}
	public rsPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
}
