package com.desmondawung.springbootstarter.topic;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

// In Spring, Business services are singletons: an instance of this class is created once and stores in its registry - not created multiple times! 
// Other classes can be dependedent on this service, and Spring will inject this dependency as appropriate
@Service   
public class TopicService {
    // using a hash table - so much easier operations and more efficient
    private Map<String, Topic> topics = createMap();
    
    private Map<String, Topic> createMap() {
        Map<String, Topic> myMap = new HashMap<>();
        myMap.put("spring", new Topic("spring", "Spring Framework", "Spring Framework Description"));
        myMap.put("java", new Topic("java", "Core Java", "Core Java Description"));
        myMap.put("javascript", new Topic("javascript", "JavaScript", "JavaScript Description"));
        
        return myMap;
    }

    public List<Topic> getAllTopics() {
        return new ArrayList<>(topics.values());    // return a list of all values in the hash table
    }

    public Topic getTopic(String id) {
        return topics.get(id);
    }

	public void addTopic(Topic topic) {
        topics.put(topic.getId(), topic);
	}

	public void updateTopic(String id, Topic topic) {
        topics.replace(id, topic);
	}

	public void deleteTopic(String id) {
        topics.remove(id);
	}
}
