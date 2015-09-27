package com.training.assignment.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.training.assignment.utils.Utils;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Attachment implements Serializable {

	private static final long serialVersionUID = 3804887503905159512L;
	private String id;
	@NotNull
	@Size(min = 5, max = 200)
	private String assignment;
	@Size(min = 0, max = 20000)
	private int fileSize = 0;
	private Long createdBy;
	@NotNull
	private Date createdOn;
	@NotNull
	private String originalFileName;
	@NotNull
	private String newFileName;
	@NotNull
	private int fileSequence;

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
		return originalFileName;
	}

	public void setOriginalFileNames(String originalFileNames) {
		this.originalFileName = originalFileNames;
	}

	public String getEncryptedFileNames() {
		return Utils.ATTACHMENT_FOLDER + newFileName;
	}

	public void setEncryptedFileNames(String encryptedFileNames) {
		this.newFileName = encryptedFileNames;
	}

	public int getFileSequence() {
		return fileSequence;
	}

	public void setFileSequence(int fileSequence) {
		this.fileSequence = fileSequence;
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
