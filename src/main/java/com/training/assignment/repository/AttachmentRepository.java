package com.training.assignment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.Attachment;

@Repository("attachmentRepository")
public interface AttachmentRepository extends MongoRepository<Attachment, String> {

	List<Attachment> findAttachmentByAssignment(String id);
}
