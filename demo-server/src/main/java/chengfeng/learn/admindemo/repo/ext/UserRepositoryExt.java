package chengfeng.learn.admindemo.repo.ext;

import chengfeng.learn.admindemo.entity.User;

public interface UserRepositoryExt extends AdditonalCommonInterface<User,Long>{
	void aCustomizedMethodInUserRepository();
}
