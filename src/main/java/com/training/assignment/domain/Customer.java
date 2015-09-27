package com.training.assignment.domain;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import flexjson.JSONSerializer;

/**
 * This is a domain object to handle compound interest .
 * 
 */
@Entity(name = "customer")
public class Customer {

	@Id
	private String id;
	private String fname;
	private String lname;
	@DBRef
	private ContactDetail contact;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;   
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public ContactDetail getContact() {
		return contact;
	}

	public void setContact(ContactDetail contact) {
		this.contact = contact;
	}

	public static String toJson(Customer customer) {
		return new JSONSerializer().exclude("*.class").include("contact").serialize(customer);
	}

	public static String toJsonArray(List<Customer> customers) {
		return new JSONSerializer().exclude("*.class").serialize(customers);
	}

}
