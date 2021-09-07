package com.example.demoapp.users;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

	@Autowired
	private UserGateway userGateway;
	
	@Test
	public void getUserById() {
		Optional<UserResponse> response=userGateway.getUserById(1);
		// Assert
		assertTrue(response.isPresent());
		assertEquals(1,response.get().getId());
		assertEquals("Bret",response.get().getUsername());
	}

}
