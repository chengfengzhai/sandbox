package chengfeng.learn.admindemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chengfeng.learn.admindemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
