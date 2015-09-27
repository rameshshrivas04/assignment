package com.training.assignment.service;

import java.util.List;

import com.training.assignment.domain.Student;

public interface StudentService {

	 Student findOne(String id);
	 List<Student> findAll();
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	void deleteStudent(Student student);
}
