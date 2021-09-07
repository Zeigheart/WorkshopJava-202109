package com.example.demoapp.employees;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;

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
		EmployeeResponse response=employeeService.getById(Integer.valueOf(id));
		return response;
	}
	
	public EmployeeResponse getById(int id) throws EmployeeNotFoundException
	{
		Optional<Employee> result=employeeRepository.findById(id);
		if(result.isPresent())
		{
			EmployeeResponse response=new EmployeeResponse();
			response.setId(result.get().getId());
			response.setName(result.get().getName());
			return response;
		}
		throw new EmployeeNotFoundException("Employee not found id=" + id);
	}
}
