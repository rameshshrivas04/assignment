package com.training.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.Assignment;

@Repository("assignmentRepository")
public interface AssignmentRepository extends MongoRepository<Assignment, String> {

}
