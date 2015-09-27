package com.training.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.training.assignment.domain.Assignment;
import com.training.assignment.domain.Attachment;
import com.training.assignment.service.AssignmentService;
import com.training.assignment.service.AttachmentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> addAssignment(@RequestBody Assignment assignment) {
		assignment = assignmentService.save(assignment);
		return new ResponseEntity<String>(Assignment.toJson(assignment),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> getAssignment() {

		System.out.println("hello");
		return new ResponseEntity<String>(
				Assignment.toJsonArray(assignmentService.findAll()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	ResponseEntity<String> uploadFile(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		System.out.println("----------------1");
		assignmentService.addFiles(id, file);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> deleteAll() {

		List<Assignment> assignments = assignmentService.findAll();
		for(Assignment assignment : assignments){
			assignmentService.delete(assignment);
		}
		return new ResponseEntity<String>(
				Assignment.toJsonArray(assignmentService.findAll()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findAttachments", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> findAttachments() {
		return new ResponseEntity<String>(
				Attachment.toJsonArray(attachmentService.findAll()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteAttachments", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> deleteAttachments() {
		List<Attachment> attachList = attachmentService.findAll();
		for(Attachment attachment : attachList){
			attachmentService.delete(attachment);
		}
		return new ResponseEntity<String>(
				Attachment.toJsonArray(attachmentService.findAll()), HttpStatus.OK);
	}
}
