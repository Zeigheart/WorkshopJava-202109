package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerWebMvcTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getEmployeeById() throws Exception {
		MvcResult result=mvc.perform(get("/employees/1")).andExpect(status().isOk())
					.andReturn();
		byte[] json=result.getResponse().getContentAsByteArray();
		ObjectMapper mapper=new ObjectMapper();
		EmployeeResponse response=mapper.readValue(json, EmployeeResponse.class);
		// Assert
		assertEquals(1,response.getId());
		assertEquals("apiwat",response.getName());
	}

}
