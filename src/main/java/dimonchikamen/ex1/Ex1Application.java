package dimonchikamen.ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity
@SpringBootApplication
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args);
	}

}
