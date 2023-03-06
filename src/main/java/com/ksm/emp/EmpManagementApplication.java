package com.ksm.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpManagementApplication.class, args);
		System.out.println("\n\nYour Application is running succesfully");
		System.out.println("\n\nUsed ModelAndView to return view page names and used thymeleaf to connect to web pages. "
				+ "\nCould not able to configure SWAGGER\n\n");
		}
	

}
