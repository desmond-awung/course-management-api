package com.desmondawung.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// In Spring, Business services are singletons: an instance of this class is created once and stores in its registry - not created multiple times! 
// Other classes can be dependedent on this service, and Spring will inject this dependency as appropriate
@Service   
public class TopicService {

    // when Spring creates an intance of the TopicService, it will inject an instance of the TopicRepository
    @Autowired
    private TopicRepository topicRepository;

    // READ all rows from table
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        // findAll returns an iterable. To convert this to a List we use a method reference:
        // loop thru iterable, and for each elt, add to the end of the list 
        topicRepository.findAll().forEach(topics :: add);    
        
        return topics;    // return a list of all values in the hash table
    }

    // READ a specific row from the table, given its primary id. Throws an exception if this id is not found in the table
    public Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

    // CREATE/INSERT a row into the table 
	public void addTopic(Topic topic) {
        topicRepository.save(topic);
	}

    // UPDATE a row in the table. 
    // save() first checks if a row with this primary id exists, and if it does, it just updates this row 
	public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
        topicRepository.deleteById(id);
	}
}
