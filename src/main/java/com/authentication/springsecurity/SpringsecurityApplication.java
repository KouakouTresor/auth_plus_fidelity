package com.authentication.springsecurity;

import com.authentication.springsecurity.entity.entitytUser.Role;
import com.authentication.springsecurity.entity.entitytUser.User;
import com.authentication.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SpringsecurityApplication  {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init(){
		User user = new User(
				"tresor",
				"kouakou",
				"tresor@gmail.com",
				passwordEncoder.encode("password"),
				Arrays.asList(
						new Role("ROLE_USER"),
						new Role("ROLE_ADMIN")));

		if (userRepository.findByEmail(user.getEmail()) == null){
			userRepository.save(user);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
