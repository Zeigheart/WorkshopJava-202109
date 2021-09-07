package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerFailureTest {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@DisplayName("เกิด Error 404 เมื่อค้นหา id = 1 ไม่เจอ ")
	public void case01()
	{
		// Arrange
        int id = 1;
        // Act
		ErrorResponse result=restTemplate.getForObject("/employees/" + id, ErrorResponse.class);
		// Assert
		assertEquals(404,result.getCode());
		assertEquals("Employee not found id=1",result.getDetail());
	}

}
