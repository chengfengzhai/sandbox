package chengfeng.learn.admindemo.dto.httpjson;

public class SimpleResponseMessage {
	private String message;

	public SimpleResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
