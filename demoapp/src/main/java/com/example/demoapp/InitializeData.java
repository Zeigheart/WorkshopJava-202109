package com.example.demoapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demoapp.employees.Employee;
import com.example.demoapp.employees.EmployeeRepository;

//@Configuration
public class InitializeData {
	
	@Autowired
	EmployeeRepository employeeRepository;

	//@PostConstruct
	public void prepareData()
	{
		Employee employee=new Employee();
		employee.setName("apiwat");
		employeeRepository.save(employee);
	}
}
