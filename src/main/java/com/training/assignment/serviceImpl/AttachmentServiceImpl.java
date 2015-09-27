package com.training.assignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.assignment.domain.Attachment;
import com.training.assignment.repository.AttachmentRepository;
import com.training.assignment.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	@Override
	public Attachment findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> findAttachmentByAssignmentId(String id) {
		return attachmentRepository.findAttachmentByAssignment(id);
	}

	@Override
	public List<Attachment> findAll() {
		return attachmentRepository.findAll();
	}
	
	@Override
	public Attachment save(Attachment attachment) {
		attachmentRepository.save(attachment);
		return attachment;
	}

	@Override
	public Attachment update(Attachment attachment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Attachment attachment) {
		attachmentRepository.delete(attachment);

	}

}
