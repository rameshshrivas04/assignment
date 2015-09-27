package com.training.assignment.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Assignment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4825365424458121353L;
	@Id
	private String id;
	private String assignmentType;
	private String assignmentName;
	private String description;
	private String level;
	private String referenceUrls;
	private boolean adminApproved;
	private Long createdBy;
	private Date createdOn;
	@DBRef
	List<Attachment> attachments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getReferenceUrls() {
		return referenceUrls;
	}

	public void setReferenceUrls(String referenceUrls) {
		this.referenceUrls = referenceUrls;
	}

	public boolean isAdminApproved() {
		return adminApproved;
	}

	public void setAdminApproved(boolean adminApproved) {
		this.adminApproved = adminApproved;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String toJson(Assignment assignment) {
		return new JSONSerializer().exclude("*.class").serialize(assignment);
	}

	public static Assignment toObjct(String json) {
		return new JSONDeserializer<Assignment>().deserialize(json,
				Assignment.class);
	}

	public static String toJsonArray(List<Assignment> assignments) {
		return new JSONSerializer().exclude("*.class").include("attachments").serialize(assignments);
	}

}
