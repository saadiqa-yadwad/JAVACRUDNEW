package com.example.test.entities;

import jakarta.persistence.*;

@Entity 
public class Employees {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int emp_id;
	
	private String emp_name;
	
	private int emp_age;
	
	private  String emp_post;
	
	private String address;

	public int getEmp_id() {
		return emp_id;
	}
	
	

	@Override
	public String toString() {
		return "Employees [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_age=" + emp_age + ", emp_post="
				+ emp_post + ", address=" + address + "]";
	}



	public Employees(int emp_id, String emp_name, int emp_age, String emp_post, String address) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_post = emp_post;
		this.address = address;
	}

	public Employees()
	{
		
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}

	public String getEmp_post() {
		return emp_post;
	}

	public void setEmp_post(String emp_post) {
		this.emp_post = emp_post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	
	
}
