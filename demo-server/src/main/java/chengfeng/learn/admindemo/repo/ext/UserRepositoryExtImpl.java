package chengfeng.learn.admindemo.repo.ext;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;

import chengfeng.learn.admindemo.entity.User;

//@Repository
public class UserRepositoryExtImpl extends BaseJpaRepositoryImpl<User, Long> implements UserRepositoryExt{
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryExtImpl.class);

	/*
	public UserRepositoryExtImpl(Class<User> domainClass, EntityManager em) {
		super(User.class, em);
	}
	*/
	
	public UserRepositoryExtImpl(EntityManager em) {
		super(User.class, em);
	}

	@Override
	public void aCustomizedMethodInUserRepository() {
		logger.info("Entering aCustomizedMethodInUserRepository in UserRepositoryExtImpl ");
	}

}
