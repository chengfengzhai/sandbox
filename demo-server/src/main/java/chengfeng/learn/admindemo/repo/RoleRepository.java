package chengfeng.learn.admindemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chengfeng.learn.admindemo.entity.Role;
import chengfeng.learn.admindemo.entity.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByType(RoleType type);
}
