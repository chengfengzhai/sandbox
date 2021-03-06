package chengfeng.learn.admindemo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="USER")
//if jackson tries to transform an entity POJO bean to JSON object and that POJO
//Object is lazy-loaded by JPA implementation.
//e.g. if in controller class, return userRepository.getById(id) as response 
//Hibernate put an property called "hibernateLazyInitializer" with null value into
//the object. Jackson would try to put this newly added property into json object.
//this could be fixed by some ways. e.g. 1. call findById(id) instead of getById(id)
//in repository, 2. add @JsonIgnreProperties like following. 3.introduce DTO instead
//of entity bean as the object would be returned as http response by web controllers. 
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
	@Id
	@Column(name="ID")
	// GenerationType.AUTO seems not auto-created value when directly using SQL insert.
	//Instead, GenerationType.IDENTITY will auto-created value even when directly using SQL insert
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Column(name="USERNAME")
	private String username;
	
	@JsonIgnore
	@Column(name="PASSWORD", length=100)
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	public User() {
		
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;	
	}

	public User(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;	
	}

	public long getId() {
		return id;
	}

	public void setUserid(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return id + "\n" + username + "\n" + password + "\n" + email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if(roles == null) {
			roles = new HashSet<Role>();
		}
		roles.add(role);
	}
}
