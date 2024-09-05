package com.parkkb.config;

import com.parkkb.common.filter.JwtAuthFilter;
import com.parkkb.common.filter.JwtAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public JwtAuthFilter jwtAuthFilter() {
		return new JwtAuthFilter();
	}

	@Bean
	public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
		return new JwtAuthenticationEntryPoint(jwtAuthFilter());
	}

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http
				.httpBasic(withDefaults())
				.authorizeHttpRequests((authorizeRequests) ->
						authorizeRequests
								.requestMatchers("/user/signup").permitAll()
								.requestMatchers("/user/login").permitAll()
								.requestMatchers("/h2-console/**").permitAll()
								.anyRequest().authenticated()
				)
				.addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
				.csrf(AbstractHttpConfigurer::disable)
				.exceptionHandling(
						exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint()));

		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}