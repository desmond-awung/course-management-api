package com.desmondawung.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	// ask Spring to inject the topicService dependency into this class
	@Autowired
	private TopicService topicService;
	
	// GET request for all topics
	@RequestMapping("/topics")
	public List <Topic> getAllTopics() {
		// if we are returning objects, they automatically get converted to JSON and sent as the HTTP response
		return topicService.getAllTopics();
	}

	// GET request for a specific topic
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {	// maps the id in the route to the id param in this method. 
	// @RequestMapping("/topics/{foo}") // ==> not recommended 
	// public Topic getTopic(@PathVariable("foo") String id) {	// if both don't match
		return topicService.getTopic(id);
	}

	// POST request to add a topic to the list of topics
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {	// request payload will contain JSON representation of a Topic instance
		topicService.addTopic(topic);
	}

	// PUT request to update a topic
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {	// request payload will contain JSON representation of a Topic instance
		topicService.updateTopic(id, topic);
	}

	// DELETE request to delete a topic
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {	// request payload will contain JSON representation of a Topic instance
		topicService.deleteTopic(id);
	}

}
