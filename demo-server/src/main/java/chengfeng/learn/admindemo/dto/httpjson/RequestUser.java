package chengfeng.learn.admindemo.dto.httpjson;

import javax.validation.constraints.NotBlank;

public class RequestUser extends SimpleUser{
	@NotBlank
	protected String password;

	public RequestUser(String username, String password) {
		super(username);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}