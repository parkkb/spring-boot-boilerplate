package com.themoin.overseasremittance.config;

import static org.springframework.security.config.Customizer.*;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.themoin.overseasremittance.common.filter.JwtAuthFilter;
import com.themoin.overseasremittance.infrastructure.user.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final UserService userService;

	public SecurityConfig(UserService userService) {this.userService = userService;}

	@Bean
	public JwtAuthFilter jwtAuthFilter() {
		return new JwtAuthFilter();
	}

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{

		http
				.httpBasic(withDefaults())
				.formLogin(withDefaults())
				.authorizeHttpRequests((authorizeRequests)->
						authorizeRequests
								.requestMatchers("/user/signup").permitAll()
								.requestMatchers("/user/login").permitAll()
								.requestMatchers(PathRequest.toH2Console()).permitAll()
								.anyRequest().authenticated()
						)
				.csrf(AbstractHttpConfigurer::disable)
				.addFilter(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);


		return http.build();

	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}