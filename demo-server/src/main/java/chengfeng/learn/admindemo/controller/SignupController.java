package chengfeng.learn.admindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chengfeng.learn.admindemo.SignupException;
import chengfeng.learn.admindemo.dto.httpjson.RequestUser;
import chengfeng.learn.admindemo.dto.httpjson.SimpleResponseMessage;
import chengfeng.learn.admindemo.service.UserService;

@CrossOrigin(origins = "*", maxAge = 1800)
@RestController
@RequestMapping("/api/signup")
public class SignupController {
	  @Autowired
	  UserService userService;

	  @PostMapping
	  public ResponseEntity<?> signupUser(@Validated @RequestBody RequestUser signupUser) {
		  try {
			userService.signup(signupUser);
		} catch (SignupException e) {
			return ResponseEntity.badRequest().body(new SimpleResponseMessage(e.getMessage()));
		}
		  return ResponseEntity.ok(new SimpleResponseMessage("User registered successfully!"));
	  }

}
