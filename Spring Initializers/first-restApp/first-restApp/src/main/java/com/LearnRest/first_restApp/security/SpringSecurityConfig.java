package com.LearnRest.first_restApp.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("Abhilash", "abbui");
		UserDetails userDetails2 = createNewUser("Srinivas", "bubbui");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

	private UserDetails createNewUser(String userName, String password) {
		Function<String, String> passwordEncoder
		= input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username(userName)
									.password(password)
									.roles("USER","ADMIN")
									.build();
		return userDetails;
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		http.httpBasic(withDefaults());
		
		http.csrf().disable(); // for POst and PUT to work
		http.headers().frameOptions().disable();
		return http.build();
	}
	
}
