package com.Blogger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Blogger2Application {

	public static void main(String[] args) {
		SpringApplication.run(Blogger2Application.class, args);
	}

//	@Bean
//	public PasswordEncoder getEncodedPassword(){
//		return new BCryptPasswordEncoder();
//	}


}