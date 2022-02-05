package chengfeng.learn.admindemo.dto.httpjson;

import javax.validation.constraints.NotBlank;

public class SimpleUser {
	@NotBlank
	protected String username;

	public SimpleUser(String username){
		this.username = username;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
