package chengfeng.learn.admindemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chengfeng.learn.admindemo.entity.Role;
import chengfeng.learn.admindemo.entity.RoleType;
import chengfeng.learn.admindemo.repo.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public Role getDefaultRole() {
		return roleRepository.findByType(RoleType.ROLE_USER).get();
	}
	
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
}
