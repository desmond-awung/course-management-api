package com.desmondawung.courseapi.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Spring Data JPA provides an interface: CrudRepository, and its class implementation which contains the logic for any @Entity class
// the basic methods to Create, Read one / all rows, Update a row or Delete a row are all included in this implementation
// all we need to add are our custom operations specific to us 
// CrudRepository<ClassName, IdType>
public interface CourseRepository extends CrudRepository<Course, String>{

    // for custom methods, providing a name in this structured way gives Spring Data JPA a hint on how to filter
    // public List<Course> getCousesByTopicId(String topicId);

    // public List<Course> findByName(String name); // find all courses based on the name (findByFieldName)
    // public List<Course> findByDescription(String description); // find all courses based on the name

    // in case we want to find a field in an object, specify the field name in the Course class + the field name in the Topic Class (findByTopic won't work: we need a primitive)
    public List<Course> findByParentTopicId(String topicId);


    
}
