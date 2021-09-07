package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@Test
	public void getById() throws EmployeeNotFoundException
	{
		// Arrange
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("Mock name");
		when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
		// Act
		EmployeeService employeeService=new EmployeeService(employeeRepository);
		EmployeeResponse result=employeeService.getById(1);
		// Assert
		assertEquals(1,result.getId());
		assertEquals("Mock name",result.getName());
	}
	
	@Test
	public void employee_not_found_case()
	{
		// Arrange
		int id=1;
		when(employeeRepository.findById(1)).thenReturn(Optional.empty());
		// Act
		EmployeeService employeeService=new EmployeeService(employeeRepository);
		try
		{
			EmployeeResponse result=employeeService.getById(id);
		}
		catch(EmployeeNotFoundException Exception)
		{
			// Assert
			assertEquals("Employee not found id=" + id,Exception.getMessage());
		}
		
	}
	
	
	@Test
	public void employee_not_found_withjnit5()
	{
		// Arrange
		int id=1;
		when(employeeRepository.findById(1)).thenReturn(Optional.empty());
		// Act
		EmployeeService employeeService=new EmployeeService(employeeRepository);

		EmployeeNotFoundException result= assertThrows(EmployeeNotFoundException.class , () ->  { 
			employeeService.getById(id);
		});
		// Assert
		assertEquals("Employee not found id=" + id,result.getMessage());
		
	}
}
