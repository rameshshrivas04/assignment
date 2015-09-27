package com.training.assignment.serviceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.assignment.domain.Assignment;
import com.training.assignment.domain.Attachment;
import com.training.assignment.repository.AssignmentRepository;
import com.training.assignment.service.AssignmentService;
import com.training.assignment.service.AttachmentService;
import com.training.assignment.utils.Utils;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	AttachmentService attachmentService;

	@Override
	public Assignment findOne(String id) {
		return assignmentRepository.findOne(id);
	}

	@Override
	public List<Assignment> findAll() {
		List<Assignment> assignments = assignmentRepository.findAll();
		for (Assignment assignment : assignments) {
			assignment.setAttachments(attachmentService
					.findAttachmentByAssignmentId(assignment.getId()));
		}
		return assignments;
	}

	@Override
	public Assignment save(Assignment assignment) {
		if (null != assignment && !assignment.getAssignmentName().isEmpty()
				&& !assignment.getDescription().isEmpty()
				&& !assignment.getAssignmentType().isEmpty()
				&& !assignment.getLevel().isEmpty()) {
			assignment.setCreatedOn(new Date());
			return assignmentRepository.save(assignment);
		}
		return null;
	}

	@Override
	public boolean addFiles(String id, MultipartFile file) {
		Assignment assignment = this.findOne(id);
		Attachment attachment = new Attachment();
		try {
			byte[] bytes = file.getBytes();

			String fileName = new Date().getTime()
					+ file.getOriginalFilename().substring(
							file.getOriginalFilename().lastIndexOf("."));

			// Create the file on server
			System.out.println("----------------2");

			File serverFile = new File(Utils.ATTACHMENT_FOLDER + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			System.out.println("----------------3");

			attachment.setAssignment(assignment.getId());
			attachment.setFileSize((int) (attachment.getFileSize() + file
					.getSize()));
			attachment.setEncryptedFileNames(fileName);
			attachment = attachmentService.save(attachment);
			System.out.println("----------------4");

		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());

		}
		return true;
	}

	@Override
	public void delete(Assignment assignment) {
		assignmentRepository.delete(assignment.getId());
	}

	@Override
	public Assignment update(Assignment assignment) {
		// TODO Auto-generated method stub
		return null;
	}

}
