package com.employee.job.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.job.DAO.employeeDAO;
import com.employee.job.VO.VOEmployees;
import com.employee.job.VO.VOWorkedHours;
import com.employee.job.VO.rqGetWorkedHoursPayment;
import com.employee.job.VO.rqNewEmployee;
import com.employee.job.VO.rqWorkedHours;
import com.employee.job.VO.rsGetEmployee;
import com.employee.job.VO.rsGetWorkedHours;
import com.employee.job.VO.rsNewEmployeeHour;
import com.employee.job.VO.rsPayment;

@Service
public class employeeService
{
	@Autowired
	employeeDAO employeeDAO;

	public rsNewEmployeeHour newEmployee(rqNewEmployee emp)
	{
		rsNewEmployeeHour rt = new rsNewEmployeeHour();
		int diffDays;
		Date DateNow = new Date(System.currentTimeMillis());
		
		// Se divide entre 86400000 para obtener los días.
		diffDays = (int) ((DateNow.getTime() - emp.getBirthdate().getTime()) / 86400000);
		
		// 6570 días es los que debe haber si es mayor de edad
		if (diffDays > 6570)
		{
			// Comprueba que no este registrado el nombre o apellido
			if (employeeDAO.existEmployee(emp.getName(), emp.getLast_name(), 0) == 0)
			{
				// Comprueba que exista el genero y puesto existan
				if (employeeDAO.existGenderJob(emp.getGender_id(), emp.getJob_id()) > 1)
				{
					rt = employeeDAO.newEmployee(emp);
				}
			}
		}
		
		return rt;
	}

	public rsNewEmployeeHour newWorkedHour(rqWorkedHours woHours)
	{
		rsNewEmployeeHour rt = new rsNewEmployeeHour();		
		java.util.Date 	date = new java.util.Date();
		
		java.time.LocalDate.now();
		
		// Valida que los parametros sean correctos
		if (woHours.getEmployee_id() != 0 && woHours.getWorked_date().before(date) && woHours.getWorked_hours() <= 20 )
		{
			// Valida que el empleado exista
			if (employeeDAO.existEmployee("", "", woHours.getEmployee_id()) > 0 )
				rt = employeeDAO.newWorkedHour(woHours);			
		}
		
		return rt;
	}
	
	public rsGetEmployee getEmployeeByJobId(int JobId)
	{
		rsGetEmployee rt = new rsGetEmployee();
		
		rt.setSuccess(false);
		// Se esta enviando solo el JobId, si existe devovlerá una coincidencia, ya que no se envia el Gender Id
		if (employeeDAO.existGenderJob(0, JobId) == 1)
		{
			rt.setEmployeeList(employeeDAO.getEmployeeByJobId(JobId));
			rt.setSuccess(true);
		}
		
		return rt;
	}
	
	public rsGetWorkedHours getWorkedHours(rqGetWorkedHoursPayment rq)
	{
		rsGetWorkedHours rt = new rsGetWorkedHours();
		
		// Valida que el empleado exista
		if (employeeDAO.existEmployee("", "", rq.getEmployee_id()) > 0 )
		{
			// Valida las fechas
			if (rq.getStart_date().before(rq.getEnd_date()))
				rt = employeeDAO.getWorkedHours(rq);
		}
		
		return rt;
	}
	
	public rsPayment getPaymentHours(rqGetWorkedHoursPayment rq)
	{
		rsPayment rt = new rsPayment();
		
		// Valida que el empleado exista
		if (employeeDAO.existEmployee("", "", rq.getEmployee_id()) > 0 )
		{
			// Valida las fechas
			if (rq.getStart_date().before(rq.getEnd_date()))
				rt = employeeDAO.getPaymentHours(rq);
		}
		
		
		String Palabra = "leopard56";
		String resultado = Palabra.toUpperCase().charAt(0) + Palabra.substring(1, Palabra.length()).toLowerCase();

		
		return rt;
	}
}
