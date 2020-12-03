package com.desmondawung.springbootstarter.topic;

import java.util.List;
// import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	// ask Spring to inject the topicService dependency into this class
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List <Topic> getAllTopics() {
		// if we are returning objects, they automatically get converted to JSON and sent as the HTTP response
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {	// maps the id in the URI to the id param in this method. 
	// @RequestMapping("/topics/{foo}") // ==> not recommended 
	// public Topic getTopic(@PathVariable("foo") String id) {	// if both don't match
		return topicService.getTopic(id);
	}

}
