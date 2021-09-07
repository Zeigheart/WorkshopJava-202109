package com.example.demoapp.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {
	
	//@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	public UserGateway(RestTemplateBuilder builder)
	{
		this.restTemplate=builder.build();
	}
	
	public Optional<UserResponse> getUserById(int id)
	{
		String url="https://jsonplaceholder.typicode.com/users/" + id;
		try
		{
			UserResponse result=restTemplate.getForObject(url, UserResponse.class);
			return Optional.ofNullable(result);
		}
		catch(RestClientException exeption)
		{
			return Optional.empty();
		}
		
	}
}
