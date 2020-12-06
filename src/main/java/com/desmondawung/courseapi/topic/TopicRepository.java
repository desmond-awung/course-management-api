package com.desmondawung.courseapi.topic;

import org.springframework.data.repository.CrudRepository;

// Spring Data JPA provides an interface: CrudRepository, and its class implementation which contains the logic for any @Entity class
// the basic methods to Create, Read one / all rows, Update a row or Delete a row are all included in this implementation
// all we need to add are our custom operations specific to us 
// CrudRepository<ClassName, IdType>
public interface TopicRepository extends CrudRepository<Topic, String>{


    
}
