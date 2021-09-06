package com.example.demoapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DemoappApplication.class, args);
		//Bean
		System.out.println(context.getBeanDefinitionCount());
		String[] beanNames=context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(System.out::println);
	}

}
