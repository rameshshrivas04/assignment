package com.training.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.Student;

@Repository("studentRepository")
public interface StudentRepository extends MongoRepository<Student, Long>{

 }
