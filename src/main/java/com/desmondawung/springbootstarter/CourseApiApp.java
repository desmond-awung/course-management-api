/**
 * 
 */
package com.desmondawung.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// tells Spring boot this is the starting point of the application
// Spring boot starts the app, creates a servlet container and hosts this app in that container
public class CourseApiApp {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
		

	}

}
