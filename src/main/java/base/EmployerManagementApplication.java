package base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@ImportResource("classpath:applicationContext.xml")
public class EmployerManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployerManagementApplication.class, args);
	}

}
