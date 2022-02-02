package chengfeng.learn.admindemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

	@GetMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/error")
	public String error() {
		return "Error ! ";
	}

}