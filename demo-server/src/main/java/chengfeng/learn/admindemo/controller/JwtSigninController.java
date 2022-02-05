package chengfeng.learn.admindemo.controller;

import java.util.List;
import java.util.stream.Collectors;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chengfeng.learn.admindemo.dto.httpjson.RequestUser;
import chengfeng.learn.admindemo.dto.httpjson.jwt.JwtAuthorizedUser;
import chengfeng.learn.admindemo.security.UserDetailsImpl;
import chengfeng.learn.admindemo.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 1800)
@RestController
@RequestMapping("/api/signin")
public class JwtSigninController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody RequestUser loginRequestUser) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequestUser.getUsername(), loginRequestUser.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtAuthorizedUser(jwt, userDetails.getId(), userDetails.getUsername(), roles));
	}
}