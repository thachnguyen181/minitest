package tma.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tma.com.dto.UserDTO;
import tma.com.model.User;
import tma.com.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//------------------ CREATE NEW USER ------------------//
	@PostMapping(value="/users")
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDto) {
		User userCreated = userService.insert(userDto);
		if (userCreated != null) {
			return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<User>(userCreated, HttpStatus.BAD_REQUEST);
		}
	}
}