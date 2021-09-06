package com.example.demoapp.employees;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public EmployeeResponse getById(Integer id) {
		EmployeeResponse employee=new EmployeeResponse();
		employee.setId(Integer.valueOf(id));
		employee.setName("apiwat");
		return employee;
	}
	
	
}
