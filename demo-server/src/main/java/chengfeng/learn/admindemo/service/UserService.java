package chengfeng.learn.admindemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import chengfeng.learn.admindemo.SignupException;
import chengfeng.learn.admindemo.dto.httpjson.RequestUser;
import chengfeng.learn.admindemo.dto.httpjson.jwt.JwtAuthorizedUser;
import chengfeng.learn.admindemo.entity.User;
import chengfeng.learn.admindemo.repo.RoleRepository;
import chengfeng.learn.admindemo.repo.UserRepository;
import chengfeng.learn.admindemo.utility.DtoTransformer;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	RoleService roleService;
	
	public void aTestUserServiceMethod() {
		System.out.println("Entered aTestUserServiceMethod!");
	}
	
	public void signup(RequestUser jsonUser) throws SignupException {
		String username = jsonUser.getUsername();
		if(userRepository.existsByUsername(username)) {
			throw new SignupException("The username " + username + " is already taken!"); 
		}
		User user = DtoTransformer.buildEntityUser(jsonUser);
		user.setPassword(encoder.encode(user.getPassword()));
		user.addRole(roleService.getDefaultRole());
		userRepository.insert(user);
	}	
}
