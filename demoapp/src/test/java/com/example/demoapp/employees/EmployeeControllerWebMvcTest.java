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
		int id=11;
		MvcResult result=mvc.perform(get("/employees/" + id)).andExpect(status().isOk())
					.andReturn();
		// Response Body
		byte[] json=result.getResponse().getContentAsByteArray();
		ObjectMapper mapper=new ObjectMapper();
		EmployeeResponse response=mapper.readValue(json, EmployeeResponse.class);
		// Assert
		assertEquals(id,response.getId());
		assertEquals("apiwat",response.getName());
	}

}
