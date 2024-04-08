package com.themoin.overseasremittance.config;

import static org.springframework.security.config.Customizer.*;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/*@Bean
	protected SecurityFilterChain configure(HttpSecurity http, HttpSecurity httpSecurity) throws Exception{

		httpSecurity
				.httpBasic(withDefaults())
				.formLogin(withDefaults())
				.authorizeHttpRequests((authorizeRequests)->
						authorizeRequests
								*//*.requestMatchers("/user/signup").permitAll()
								.requestMatchers("/h2-console/**").permitAll()*//*
								.anyRequest().permitAll()
						)
				.csrf(AbstractHttpConfigurer::disable);


		return http.build();

	}*/


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}