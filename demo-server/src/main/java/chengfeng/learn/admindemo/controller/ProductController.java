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

import chengfeng.learn.admindemo.entity.Product;
import chengfeng.learn.admindemo.repo.ProductRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 1800)
@PreAuthorize("hasRole('USER')") //means that there should be a role called "ROLE_USER" actually 
@RequestMapping(path = "/api/product")
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping(path = "/all")
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public Product getUser(@PathVariable long id) {
		logger.info("path variable id : " + id);
		return productRepository.findById(id).get();
	}

}
