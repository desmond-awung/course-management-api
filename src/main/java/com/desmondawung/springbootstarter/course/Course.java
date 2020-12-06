package com.desmondawung.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.desmondawung.springbootstarter.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

// @ Entity tells JPA to create a table called "Course" in the DB with the number of columns eqiual to this class' fields.
// each instance of this class will be inserted as a row in the table
@Entity
public class Course {

	// @Id means this class member (String id) will be marked as the primary key in the table
	@Id
	private String id;
	private String name;
	private String description;
	private String parentTopicId;

	// mapping courses to a topic: many-to-one relationship
	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
	// no arg constructor, so the objects are easier to initialize
	public Course() {

	}
	
	// public Course(String id, String name, String description) {
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentTopicId = topicId;
		this.topic = new Topic(topicId, "", "");	// TODO creating a new instance of a topic for every course???
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    public String getParentTopicId() {
        return parentTopicId;
    }

    public void setParentTopicId(String parentTopicId) {
        this.parentTopicId = parentTopicId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
