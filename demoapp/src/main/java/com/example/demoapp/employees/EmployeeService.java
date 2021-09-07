package com.example.demoapp.employees;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository2) {
		// TODO Auto-generated constructor stub
		employeeRepository=employeeRepository2;
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
