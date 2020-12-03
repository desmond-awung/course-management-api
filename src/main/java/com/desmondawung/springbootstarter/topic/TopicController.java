package com.desmondawung.springbootstarter.topic;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List <Topic> getAllTopics() {
//		List<Topic> topicList = new ArrayList<>();
		// creating a list in line
		// if we are returning objects, they automatically get converted to JSON and sent as the HTTP response
		return Arrays.asList(
				new Topic("spring", "Spring Framework", "Spring Framework Description"),
				new Topic("java", "Core Java", "Core Java Description"),
				new Topic("javascript", "JavaScript", "JavaScript Description")
//				new Topic("spring", "Spring Framework", "Spring Framework Description"),
//				new Topic("spring", "Spring Framework", "Spring Framework Description")
				);
		
		
	}

}
