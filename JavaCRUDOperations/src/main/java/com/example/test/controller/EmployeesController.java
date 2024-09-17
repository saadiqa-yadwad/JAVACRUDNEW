package com.example.test.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.DemoApplication;
import com.example.test.entities.Employees;
import com.example.test.entities.Students;

@RestController
public class EmployeesController 

{
	
	@Autowired 
	DemoApplication dem;
	
	
	//-----------------------DISPLAY DATA FROM BOTH TABLES ----------
	
	@GetMapping("/employees")
	public Iterable<Employees>  getEmployee()
	{
	Iterable<Employees> st=dem.emp_repo.findAll();
	
	
st.forEach(e->

		System.out.println(e)
		
		);

		
		return st;
	}
	
	
	@GetMapping("/students")
	public Iterable<Students>  getStudents()
	{
	Iterable<Students> st=dem.stu_repo.findAll();
	
	

		
		return st;
	}
	
	
	//-----------------------READ DATA BY ID FROM BOTH TABLES ----------
		
	@GetMapping("/{tablename}/read.{id}")
	public Optional  getTableDataById(@PathVariable String  tablename,@PathVariable int id)
	{
		if(tablename.equalsIgnoreCase("employees"))
		{
			Optional<Employees> st=dem.emp_repo.findById(id);
			return st;
		}
		
		else if(tablename.equalsIgnoreCase("students"))
		{
			Optional<Students> st=dem.stu_repo.findById(id);
			return st;
		}
		else
		return null;
	
	}
	
	
	
	
	//-----------------------CREATE DATA FOR BOTH TABLES ----------
	
	
	@PostMapping("/{tablename}.create")
	public Object setEmployee(@PathVariable String tablename)
	{
		if(tablename.equalsIgnoreCase("employees"))
		{
		Employees e=	dem.setEmpData("durgesh", 67, "navi mumbai", "O.S");
				return e;
		}
			
		
		
		else if(tablename.equalsIgnoreCase("students"))
		{
			Students e=	dem.saveStudentsData("hamza", 67);
		return e;
		
		}
		else
			return null;
	}
	
	
	//-----------------------CREATE DATA FOR  Student TABLE----------
	
	@PostMapping("/students.create/{a}/{b}")
	public Students createStudent(@PathVariable String a,@PathVariable int b)
	{
		Students e=new Students();
		e.setStu_name(a);
		e.setStu_Percentage(b);
		
e=dem.stu_repo.save(e);
	
	

		
		return e;
	}
	
	
	//create Employee data record---------
	
	
	@PostMapping("/employees.create/{id}/{name}/{Add}/{post}/{age}")
	public Employees createEmployee(@PathVariable int id,
			@PathVariable String name,@PathVariable String Add
			,@PathVariable String post ,@PathVariable int age
			
			)
	{
		Employees e=	dem.setEmpData("naveen ", 67, "navi mumbai", "O.S.A");
		return e;

	}
	
	

	
//Update both table data based 	
	
	//employee update
	
	@PutMapping("/employees.update/{id}/{name}/{Add}/{post}/{age}")
	public Employees updateEmployee(@PathVariable int id,
			@PathVariable String name,@PathVariable String Add
			,@PathVariable String post ,@PathVariable int age
			
			)
	{
		Employees e=new Employees();
		Optional<Employees> o=dem.emp_repo.findById(id);
		e= o.get();
		e.setEmp_name(name);
		e.setAddress(Add);
		e.setEmp_post(post);
		e.setEmp_age(age);
		
e=dem.emp_repo.save(e);
	
	

		
		return e;
	}
	
	//  student update 
	@PutMapping("/students.update/{id}/{name}/{per}")
	public Students updateStudents(@PathVariable int id,
			@PathVariable String name,@PathVariable int per
			
			
			)
	{
		Students e=new Students();
		Optional<Students> o=dem.stu_repo.findById(id);
		e= o.get();
		e.setStu_name(name);
		e.setStu_Percentage(per);
		
e=dem.stu_repo.save(e);
	
	

		
		return e;
	}
	
	
	
	//delete data of specified table 
	@DeleteMapping("/deleteAllFrom/{tablename}")
	public String  deleteAll(@PathVariable  String tablename)
	{
		if(tablename.equalsIgnoreCase("employees"))
		{
			
			dem.emp_repo.deleteAll();
			return "all Employees data deleted ";
			
		}
		else if (tablename.equalsIgnoreCase("students"))
		{
			
			dem.stu_repo.deleteAll();
			return "all student data deleted ";
			
			
		}
		
		else
			return null;
	

		
		
	}
	
	
	
	
	//delete data by if of spedified table
	
	@DeleteMapping("/deleteIdfrom/{tablename}/{id}")
	public String  deleteDataById(@PathVariable String tablename,@PathVariable  int id)
	{
		if(tablename.equalsIgnoreCase("employees"))
		{
			
			dem.emp_repo.deleteById(id);
			return "data of  id: "+id+" and  from tablename :"+tablename+" deleted ";
			
		}
		else if (tablename.equalsIgnoreCase("students"))
		{
			
			dem.stu_repo.deleteById(id);
			return "data of  id: "+id+" and  from tablename :"+tablename+" deleted ";
			
			
		}
		
		else
			return null;
	

		
		
	}
	
	
	

	
}
