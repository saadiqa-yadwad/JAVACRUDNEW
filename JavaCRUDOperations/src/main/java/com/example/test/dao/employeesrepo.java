package com.example.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.test.entities.Employees;

public interface employeesrepo extends CrudRepository<Employees, Integer>
{
	public List<Employees> findByAddress(String n);
	
	
	
}

