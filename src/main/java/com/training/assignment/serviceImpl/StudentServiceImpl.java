package com.training.assignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.assignment.domain.Student;
import com.training.assignment.repository.StudentRepository;
import com.training.assignment.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findOne(String id) {
		if (null == id) {
			return null;
		}
		return studentRepository.findOne(Long.parseLong(id));
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		student = studentRepository.save(student); 
		if(student.getId() != null){
			return student;
		}
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Student student) {
		 studentRepository.delete(student);
	}

}
