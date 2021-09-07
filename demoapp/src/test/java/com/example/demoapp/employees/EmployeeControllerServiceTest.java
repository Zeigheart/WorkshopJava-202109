package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {
	@Autowired
	TestRestTemplate restTemplate;
	
	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	@DisplayName("Success Case")
	public void case01()
	{
		// Arrange
        int id = 1;
        Employee employee1 = new Employee();
        employee1.setId(id);
        employee1.setName("Mock name");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee1));
        // Act
		EmployeeResponse result1=restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
		// Assert
		assertEquals(id,result1.getId());
		assertEquals("Mock name",result1.getName());
	}
}
