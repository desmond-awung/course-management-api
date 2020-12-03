package com.desmondawung.springbootstarter.topic;

// import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Service;

// In Spring, Business services are singletons: an instance of this class is created once and stores in its registry - not created multiple times! 
// Other classes can be dependedent on this service, and Spring will inject this dependency as appropriate
@Service   
public class TopicService {
    private List<Topic> topics = Arrays.asList(
        new Topic("spring", "Spring Framework", "Spring Framework Description"),
        new Topic("java", "Core Java", "Core Java Description"),
        new Topic("javascript", "JavaScript", "JavaScript Description")
//				new Topic("spring", "Spring Framework", "Spring Framework Description"),
//				new Topic("spring", "Spring Framework", "Spring Framework Description")
        );

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        // for each topic object in the topics list, compare its id field with the id string passed in
        // using lambda expressions: get the first object in the list whose id field matches
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        /*
        // won't recommend the approach below for this purpose, cuz it does not thrown an error/exception when its id is not found. 
        for (Topic topic : topics) {
            if (topic.getId().equals(id)) {
                return topic;
            }
        }
        // if no topic was found with this id
        return null; 
        */
    }
    
}
