package com.desmondawung.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// In Spring, Business services are singletons: an instance of this class is created once and stores in its registry - not created multiple times! 
// Other classes can be dependedent on this service, and Spring will inject this dependency as appropriate
@Service   
public class CourseService {

    // when Spring creates an instance of the CourseService, it will inject an instance of the CourseRepository
    @Autowired
    private CourseRepository courseRepository;

    // READ all courses for a topic
    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        // findAll returns an iterable. To convert this to a List we use a method reference:
        // loop thru iterable, and for each elt, add to the end of the list 
        courses = courseRepository.findByParentTopicId(topicId);
        
        return courses;    // return a list of all values in the hash table
    }

    // READ a specific row from the table, given its primary id. Throws an exception if this id is not found in the table
    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    // CREATE/INSERT a row into the table 
	public void addCourse(Course course) {
        courseRepository.save(course);
	}

    // UPDATE a row in the table. 
    // save() first checks if a row with this primary id exists, and if it does, it just updates this row 
	public void updateCourse(Course course) {
        courseRepository.save(course);
	}

	public void deleteCourse(String id) {
        courseRepository.deleteById(id);
	}
}
