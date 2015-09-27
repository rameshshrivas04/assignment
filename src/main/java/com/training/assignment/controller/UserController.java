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

import com.training.assignment.domain.User;
import com.training.assignment.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> addAssignment(@RequestBody User user) {
		User userFromDb =  userService.saveUser(user);
		if (null == userFromDb) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(User.toJson(userFromDb), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/findOne", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> getUser(@RequestParam(value = "id") String id) {
		User user = userService.findOne(id);
		return new ResponseEntity<String>(User.toJson(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> getUsers() {
		final List<User> users = userService.findAll();
		return new ResponseEntity<String>(User.toJsonArray(users), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	ResponseEntity<String> deleteAllUsers() {
		List<User> users = userService.findAll();
		for(User user : users){
			userService.delete(user);
		}
		return new ResponseEntity<String>(User.toJsonArray(users), HttpStatus.OK);
	}
}
