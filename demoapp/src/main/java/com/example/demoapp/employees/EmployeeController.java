package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/employees")
	public EmployeeResponse[] listEmployee()
	{
		EmployeeResponse employee01=new EmployeeResponse();
		employee01.setId(1);
		employee01.setName("apiwat");
		
		EmployeeResponse employee02=new EmployeeResponse();
		employee02.setId(2);
		employee02.setName("apiwat 2");
		
		return new EmployeeResponse[] {employee01 , employee02} ;
	}
	
	@GetMapping("/employees/{id}")
	public EmployeeResponse getEmployee(@PathVariable String id)
	{
		EmployeeResponse employee01=new EmployeeResponse();
		employee01.setId(Integer.valueOf(id));
		employee01.setName("apiwat");
		return employee01;
	}
}
