package com.training.assignment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.training.assignment.domain.Assignment;

public interface AssignmentService {

	Assignment findOne(String id);
	List<Assignment> findAll();
	Assignment save(Assignment assignment);
	Assignment update(Assignment assignment);
	void delete(Assignment assignment);
	boolean addFiles(String id, int fileSequence, MultipartFile file);
}
