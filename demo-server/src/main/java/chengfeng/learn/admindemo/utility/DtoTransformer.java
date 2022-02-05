package chengfeng.learn.admindemo.utility;


import chengfeng.learn.admindemo.dto.httpjson.RequestUser;
import chengfeng.learn.admindemo.entity.User;

public class DtoTransformer {
	public static User buildEntityUser(RequestUser userFromRequest) {
		User user = new User();
		user.setUsername(userFromRequest.getUsername());
		user.setPassword(userFromRequest.getPassword());
		return user;
	}
	
}
