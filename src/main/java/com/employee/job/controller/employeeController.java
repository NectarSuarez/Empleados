package com.employee.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.job.VO.VOEmployees;
import com.employee.job.VO.VOJobs;
import com.employee.job.VO.VOWorkedHours;
import com.employee.job.VO.rqGetEmployee;
import com.employee.job.VO.rqGetWorkedHoursPayment;
import com.employee.job.VO.rqNewEmployee;
import com.employee.job.VO.rqWorkedHours;
import com.employee.job.VO.rsGetEmployee;
import com.employee.job.VO.rsGetWorkedHours;
import com.employee.job.VO.rsNewEmployeeHour;
import com.employee.job.VO.rsPayment;
import com.employee.job.service.employeeService;

@RestController
@RequestMapping("employee")
public class employeeController
{
	@Autowired
	employeeService empService;
	
	@PostMapping(value = "/NewEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public rsNewEmployeeHour newEmployee(@RequestBody rqNewEmployee rq)
	{
		return empService.newEmployee(rq);
	}
	
	@PostMapping(value = "/NewHour", produces = MediaType.APPLICATION_JSON_VALUE)
	public rsNewEmployeeHour newWorkedHour(@RequestBody rqWorkedHours rq)
	{
		return empService.newWorkedHour(rq);
	}
	
	@PostMapping(value = "/GetEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public rsGetEmployee getEmployeeByJobId(@RequestBody rqGetEmployee rq)
	{
		return empService.getEmployeeByJobId(rq.getJob_id());
	}

	@PostMapping(value = "/GetHours", produces = MediaType.APPLICATION_JSON_VALUE)
	public rsGetWorkedHours getWorkedHours(@RequestBody rqGetWorkedHoursPayment rq)
	{
		return empService.getWorkedHours(rq);
	}
	
	@PostMapping(value = "/GetPayment", produces = MediaType.APPLICATION_JSON_VALUE)
	public rsPayment getPaymentHours(@RequestBody rqGetWorkedHoursPayment rq)
	{
		return empService.getPaymentHours(rq);
	}
	
}
