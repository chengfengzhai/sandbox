package chengfeng.learn.admindemo.dto.httpjson;

import javax.validation.constraints.NotBlank;

public class RequestUserWithEmail extends RequestUser{
	@NotBlank
	protected String email;

	public RequestUserWithEmail(String username, String password, String email) {
		super(username, password);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}