package chengfeng.learn.admindemo.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import chengfeng.learn.admindemo.CommonTestConfig;
import chengfeng.learn.admindemo.entity.Product;

@SpringBootTest
/**Can import in applications from main/src Can't do here from unit class test/main, 
 * otherwise will get IllegalStateException, found multiple @SpringBootConfiguration
 * instead, use @ContextConfiguration(classes=AppConfig.class) to load configuration
 */
//@Import(AppConfig.class) 
@ContextConfiguration(classes=CommonTestConfig.class)
@Sql({"classpath:class-level-init-load.sql"})
class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	void testFindAllAndClassLevelInitLoad() {
		List<Product> products = productRepository.findAll();
		System.out.println("total products : " + products.size());
		assertEquals(5, products.size());
	}

}
