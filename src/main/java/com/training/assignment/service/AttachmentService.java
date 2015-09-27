package com.training.assignment.service;

import java.util.List;

 

import com.training.assignment.domain.Attachment;

public interface AttachmentService {

	Attachment findOne(String id);
	List<Attachment> findAll();
	Attachment save(Attachment attachment);
	Attachment update(Attachment attachment);
	void delete(Attachment attachment);
	List<Attachment> findAttachmentByAssignmentId(String id);
}

