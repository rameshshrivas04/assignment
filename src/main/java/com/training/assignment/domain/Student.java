package com.training.assignment.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import flexjson.JSONSerializer;

@Entity
public class Student implements Serializable {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public static String toJson(Student student) {
		return new JSONSerializer().exclude("*.class").include("contact").serialize(student);
	}

	public static String toJsonArray(List<Student> students) {
		return new JSONSerializer().exclude("*.class").serialize(students);
	}
}
