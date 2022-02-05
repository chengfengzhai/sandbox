package chengfeng.learn.admindemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chengfeng.learn.admindemo.entity.User;
import chengfeng.learn.admindemo.repo.UserRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 1800)
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(path = "/api/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path = "/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public User getUser(@PathVariable long id) {
		logger.info("path variable id : " + id);
		return userRepository.searchById(id);
	}

}
