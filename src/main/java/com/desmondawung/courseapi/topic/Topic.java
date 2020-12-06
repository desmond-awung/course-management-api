package com.desmondawung.courseapi.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

// @ Entity tells JPA to create a table called "Topic" in the DB with the number of columns eqiual to this class' fields.
// each instance of this class will be inserted as a row in the table
@Entity
public class Topic {

	// @Id means this class member (String id) will be marked as the primary key in the table
	@Id
	private String id;
	private String name;
	private String description;
	
	// no arg constructor, so the objects are easier to initialize
	public Topic() {

	}
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	
}
