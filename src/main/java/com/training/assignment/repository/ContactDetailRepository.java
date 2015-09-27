package com.training.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.ContactDetail;

 
@Repository("contactDetailRepository")
public interface ContactDetailRepository extends MongoRepository<ContactDetail, Long> {

}
