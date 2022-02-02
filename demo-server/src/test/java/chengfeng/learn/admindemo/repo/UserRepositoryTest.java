package chengfeng.learn.admindemo.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import chengfeng.learn.admindemo.CommonTestConfig;

@SpringBootTest
/**Can import in applications from main/src Can't do here from unit class test/main, 
 * otherwise will get IllegalStateException, found multiple @SpringBootConfiguration
 * instead, use @ContextConfiguration(classes=AppConfig.class) to load configuration
 */
//@Import(AppConfig.class) 
@ContextConfiguration(classes=CommonTestConfig.class)
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testACustomizedMethodInUserRepository() {
		userRepository.aCustomizedMethodInUserRepository();
		
	}
	
	@Test
	void testDbAutoLoadedViaDataDotSqlFile() {
		long count = userRepository.count();
		System.out.println("Found users count: " + count);
		assertEquals(2,count);		
	}

}
