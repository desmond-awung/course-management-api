package com.desmondawung.courseapi.course;

import com.desmondawung.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

	// ask Spring to inject the courseService dependency into this class
	@Autowired
	private CourseService courseService;
	
	// GET request for all courses for a topic
	// @RequestMapping("/courses")
	@GetMapping("/topics/{topicId}/courses")
	public List <Course> getAllCourses(@PathVariable String topicId) {
		// if we are returning objects, they automatically get converted to JSON and sent as the HTTP response
		return courseService.getAllCourses(topicId);
	}

	// GET request for a specific course
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {	// maps the id in the route to the id param in this method.
		return courseService.getCourse(id);
	}

	// POST request to add a course to the list of courses for a topic
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		// for every course added, we include the id of its topic
		course.setParentTopicId(topicId);
		course.setTopic(new Topic(topicId, "", ""));	// helps with mapping a course to a topic
		courseService.addCourse(course);
	}

	// PUT request to update a course
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setParentTopicId(topicId);
		course.setTopic(new Topic(topicId, "", ""));	// helps with mapping a course to a topic
		courseService.updateCourse(course);
	}

	// DELETE request to delete a course
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String topicId, @PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
