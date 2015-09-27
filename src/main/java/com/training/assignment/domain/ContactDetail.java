package com.training.assignment.domain;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import flexjson.JSONSerializer;

@Entity
public class ContactDetail {
	@Id
	private String id;
	private String mobile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public static String toJson(ContactDetail contactDetail) {
		return new JSONSerializer().exclude("*.class").serialize(contactDetail);
	}
}
