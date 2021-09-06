package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void listEmployee()
	{
		 EmployeeResponse[] result=restTemplate.getForObject("/employees", EmployeeResponse[].class);
		// Assert
		assertEquals(2,result.length);
		assertEquals(1,result[0].getId());
		assertEquals("apiwat",result[0].getName());
	}
}
