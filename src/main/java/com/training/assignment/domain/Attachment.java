package com.training.assignment.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.training.assignment.utils.Utils;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Attachment implements Serializable {

	private static final long serialVersionUID = 3804887503905159512L;
	private String id;
	private String assignment;
	private int fileSize = 0;
	private Long createdBy;
	private Date createdOn;
	private String originalFileNames;
	private String encryptedFileNames;

	 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
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

	public String getOriginalFileNames() {
		return originalFileNames;
	}

	public void setOriginalFileNames(String originalFileNames) {
		this.originalFileNames = originalFileNames;
	}

	public String getEncryptedFileNames() {
		return Utils.ATTACHMENT_FOLDER+encryptedFileNames;
	}

	public void setEncryptedFileNames(String encryptedFileNames) {
		this.encryptedFileNames = encryptedFileNames;
	}

	public static String toJson(Attachment attachment) {
		return new JSONSerializer().exclude("*.class").serialize(attachment);
	}

	public static Attachment toObjct(String json) {
		return new JSONDeserializer<Attachment>().deserialize(json,
				Attachment.class);
	}

	public static String toJsonArray(List<Attachment> attachments) {
		return new JSONSerializer().exclude("*.class").serialize(attachments);
	}

}
