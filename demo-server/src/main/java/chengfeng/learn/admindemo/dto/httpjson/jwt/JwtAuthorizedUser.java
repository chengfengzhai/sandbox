package chengfeng.learn.admindemo.dto.httpjson.jwt;

import java.util.List;

import chengfeng.learn.admindemo.dto.httpjson.SimpleUser;

public class JwtAuthorizedUser extends SimpleUser {
	private String token;
	private String type = "Bearer";
	private Long id;
	private List<String> roles;

	public JwtAuthorizedUser(String token, Long id, String username, List<String> roles) {
		super(username);
		this.token = token;
		this.id = id;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getRoles() {
		return roles;
	}
}