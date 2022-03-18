package com.employee.job.DAO;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.employee.job.VO.VOEmployees;
import com.employee.job.VO.VOGenders;
import com.employee.job.VO.VOJobs;
import com.employee.job.VO.rqGetWorkedHoursPayment;
import com.employee.job.VO.rqNewEmployee;
import com.employee.job.VO.rqWorkedHours;
import com.employee.job.VO.rsGetWorkedHours;
import com.employee.job.VO.rsNewEmployeeHour;
import com.employee.job.VO.rsPayment;

@Repository
public class employeeDAO
{
	@Autowired
	DataSource dataSource;

	private final String NewEmployee = "empleados.NewEmployee";
	private final String ExistEmployee = "empleados.existEmployee";
	private final String ExistGenderJob = "empleados.existGenderJob";
	private final String NewWorkedHour = "empleados.NewWorkedHour";
	private final String GetEmployeeByJobId = "empleados.GetEmployeeByJobId";
	private final String GetWorkedHours = "empleados.GetWorkedHours";
	private final String GetPaymentHours = "empleados.GetPaymentHours";
	
	
	private JdbcTemplate jdbcTemplate;
	private String Cursor = "Cursor";
	
	public rsNewEmployeeHour newEmployee(rqNewEmployee emp)
	{
		rsNewEmployeeHour  rt = new rsNewEmployeeHour();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		RowMapper<String> mapaConfiguraciones = null;
		try
		{
			SqlParameterSource SPParametros = new MapSqlParameterSource()
					.addValue("inGenderId", emp.getGender_id())
					.addValue("inJobId", emp.getJob_id())
					.addValue("inName", emp.getName())
					.addValue("inLastName", emp.getLast_name())
					.addValue("inBirthdate", emp.getBirthdate())
					;
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(NewEmployee)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inGenderId", Types.INTEGER),
					new SqlParameter("inJobId", Types.INTEGER),
					new SqlParameter("inName", Types.VARCHAR),
					new SqlParameter("inLastName", Types.VARCHAR),
					new SqlParameter("inBirthdate", Types.DATE),
					new SqlOutParameter("outId", Types.INTEGER)
					);
			
			Map<String, Object> out = stored.execute(SPParametros);
			
			Integer Id = (Integer) out.get("outId");
			
			if (Id > 0)
			{
				rt.setId(Id);
				rt.setSuccess(true);
			}
			else
				rt.setSuccess(false);
			
		}
		catch(Exception E)
		{
			System.out.print(E.getMessage());
		};
		
		return rt;
	}
	
	public int existEmployee(String name, String lastName, int Id)
	{
		int outId = 0;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		RowMapper<String> mapaConfiguraciones = null;
		try
		{
			SqlParameterSource SPParametros = new MapSqlParameterSource()
					.addValue("inName", name)
					.addValue("inLastName", lastName)
					.addValue("inId", Id)
					;
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(ExistEmployee)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inName", Types.VARCHAR),
					new SqlParameter("inLastName", Types.VARCHAR),
					new SqlParameter("inId", Types.INTEGER),
					new SqlOutParameter("outId", Types.INTEGER)
					);
			
			Map<String, Object> out = stored.execute(SPParametros);
			
			outId = (Integer) out.get("outId");
		}
		catch(Exception E)
		{
			System.out.print(E.getMessage());
		};
		
		return outId;
	}
	
	public int existGenderJob(int GenderId, int JobId)
	{
		int Id = 0;
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		RowMapper<String> mapaConfiguraciones = null;
		try
		{
			SqlParameterSource SPParametros = new MapSqlParameterSource()
					.addValue("inGenderId", GenderId)
					.addValue("inJobId", JobId)
					;
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(ExistGenderJob)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inGenderId", Types.INTEGER),
					new SqlParameter("inJobId", Types.INTEGER),
					new SqlOutParameter("outId", Types.INTEGER)
					);

			Map<String, Object> out = stored.execute(SPParametros);
			
			Id = (Integer) out.get("outId");

		}
		catch(Exception E)
		{
			System.out.print(E.getMessage());
		};
		
		return Id;
	}
	
	public rsNewEmployeeHour newWorkedHour(rqWorkedHours WoHours)
	{
		rsNewEmployeeHour rt = new rsNewEmployeeHour();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		RowMapper<String> mapaConfiguraciones = null;
		try
		{
			SqlParameterSource SPParametros = new MapSqlParameterSource()
					.addValue("inEmployeeId", WoHours.getEmployee_id())
					.addValue("inWorkedHours", WoHours.getWorked_hours())
					.addValue("inWorkedDate", WoHours.getWorked_date())
					;
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(NewWorkedHour)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inEmployeeId", Types.INTEGER),
					new SqlParameter("inWorkedHours", Types.INTEGER),
					new SqlParameter("inWorkedDate", Types.DATE),
					new SqlOutParameter("outId", Types.INTEGER)
					);
			
			Map<String, Object> out = stored.execute(SPParametros);
			
			Integer Id = (Integer) out.get("outId");
			
			if (Id > 0)
			{
				rt.setId(Id);
				rt.setSuccess(true);
			}
			else
				rt.setSuccess(false);
			
		}
		catch(Exception E)
		{
			System.out.print(E.getMessage());
		};
		
		return rt;
	}
	
	public List<VOEmployees> getEmployeeByJobId(int JobId)
	{
		List<VOEmployees> empList = new ArrayList<VOEmployees>();
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		RowMapper<VOEmployees> mapaConfiguraciones = null;
		
		try
		{
			mapaConfiguraciones = (RS, rowNum) ->
			{
				VOEmployees EMP = new VOEmployees();
				VOGenders 	GEN = new VOGenders();
				VOJobs 		JOB = new VOJobs();
				
				EMP.setId(RS.getInt("EmployeeId"));
				EMP.setName(RS.getString("EmployeeName"));
				EMP.setLastName(RS.getString("EmployeeLastName"));
				EMP.setBirthdate(RS.getDate("EmployeeBirthDate"));
				
				JOB.setId(RS.getInt("JobId"));
				JOB.setName(RS.getString("JobName"));
				JOB.setSalary(RS.getInt("JobSalary"));
				
				GEN.setId(RS.getInt("GenderId"));
				GEN.setName(RS.getString("GenderName"));
				
				EMP.setGender(GEN);
				EMP.setJob(JOB);
				
				return EMP;
			};
			
			SqlParameterSource In = new MapSqlParameterSource()
					.addValue("inJobId", JobId);
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(GetEmployeeByJobId)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inJobId", Types.INTEGER)
					);
			
			Map<String, Object> Out = stored.execute(In);
			
			if((List<VOEmployees>) Out.get(Cursor) != null)
			{
				empList = (List<VOEmployees>) Out.get(Cursor);
				return empList;
			}
			
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}
		
		return null;
	}
	
	
	public rsGetWorkedHours getWorkedHours(rqGetWorkedHoursPayment rq)
	{
		rsGetWorkedHours rt = new rsGetWorkedHours();
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		RowMapper<String> mapaConfiguraciones = null;
		try
		{
			SqlParameterSource SPParametros = new MapSqlParameterSource()
					.addValue("inEmployeeId", rq.getEmployee_id())
					.addValue("inStartDate", rq.getStart_date())
					.addValue("inEndDate", rq.getEnd_date())
					;
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(GetWorkedHours)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inEmployeeId", Types.INTEGER),
					new SqlParameter("inStartDate", Types.DATE),
					new SqlParameter("inEndDate", Types.DATE),
					new SqlOutParameter("outSuma", Types.INTEGER)
					);
			
			Map<String, Object> out = stored.execute(SPParametros);
			
			Integer Suma = (Integer) out.get("outSuma");
			
			if (Suma > 0)
			{
				rt.setSuccess(true);
				rt.setTotal_worked_hours(Suma);
			}
			else
				rt.setSuccess(false);
			
		}
		catch(Exception E)
		{
			System.out.print(E.getMessage());
		};
		
		return rt;
	}
	
	public rsPayment getPaymentHours(rqGetWorkedHoursPayment rq)
	{
		rsPayment rt = new rsPayment();
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		RowMapper<String> mapaConfiguraciones = null;
		try
		{
			SqlParameterSource SPParametros = new MapSqlParameterSource()
					.addValue("inEmployeeId", rq.getEmployee_id())
					.addValue("inStartDate", rq.getStart_date())
					.addValue("inEndDate", rq.getEnd_date())
					;
			
			SimpleJdbcCall stored = new SimpleJdbcCall(this.jdbcTemplate)
					.withProcedureName(GetPaymentHours)
					.returningResultSet(Cursor, mapaConfiguraciones);
			
			stored.withoutProcedureColumnMetaDataAccess();
			stored.declareParameters(
					new SqlParameter("inEmployeeId", Types.INTEGER),
					new SqlParameter("inStartDate", Types.DATE),
					new SqlParameter("inEndDate", Types.DATE),
					new SqlOutParameter("outSuma", Types.INTEGER)
					);
			
			Map<String, Object> out = stored.execute(SPParametros);
			
			Integer Suma = (Integer) out.get("outSuma");
			
			if (Suma > 0)
			{
				rt.setSuccess(true);
				rt.setPayment(Suma);
			}
			else
				rt.setSuccess(false);
			
		}
		catch(Exception E)
		{
			System.out.print(E.getMessage());
		};
		
		return rt;
	}
	
}
