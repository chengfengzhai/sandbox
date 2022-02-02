package chengfeng.learn.admindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class AdmindemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmindemoApplication.class, args);
	}

}
