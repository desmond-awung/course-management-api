package com.desmondawung.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// makes this class a REST controller in Spring
// methods in here can map to a URL request
@RestController
public class HelloController {
	
	// this executed when there is a GET request to the "/hello" URL
	@RequestMapping("/hello")	// default: only for GET. Other HTTP methods would have to be specified
	public String sayHi() {
		return "Hi";
	}

}
