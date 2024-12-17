package com.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sms.service.CustomSuccessHandler;
import com.sms.service.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(c -> c.disable())
		
		.authorizeHttpRequests(request -> request.requestMatchers("/","/smsHome","/aboutus").permitAll().
				requestMatchers("/admin-page").hasAuthority("ADMIN").
				requestMatchers("/user-page").hasAuthority("USER")
				.requestMatchers("/registration", "/css/**","/jpg/**").permitAll()
				.requestMatchers("src/main/resources/templates").permitAll()
				.anyRequest().authenticated())
		
		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
				
				.successHandler(customSuccessHandler).permitAll()
				.defaultSuccessUrl("/admin-page")
							)
		
		.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll());
		
		return http.build();
		
	}
	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

}
