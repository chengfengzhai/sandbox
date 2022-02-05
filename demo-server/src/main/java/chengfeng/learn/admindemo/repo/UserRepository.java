package chengfeng.learn.admindemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chengfeng.learn.admindemo.entity.User;
import chengfeng.learn.admindemo.repo.ext.UserRepositoryExt;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryExt{
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
}
