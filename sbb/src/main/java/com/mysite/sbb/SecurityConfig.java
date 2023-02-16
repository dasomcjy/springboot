package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration				// Security 의 설정을 적용하는 어노테이션 
@EnableWebSecurity			// http의 URL 접근을 제어하는 어노테이션 
@EnableMethodSecurity(prePostEnabled = true)  //2월 16일 수정 ,
public class SecurityConfig {
	 
		@Bean
		
		SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
			
			http.authorizeHttpRequests().requestMatchers(
					
					new AntPathRequestMatcher("/**")).permitAll()
			
				.and()
				
					.csrf().ignoringRequestMatchers(
							
							new AntPathRequestMatcher("/h2-console/**"))
					
				.and()
				
				    .headers()
				    
				    .addHeaderWriter(new XFrameOptionsHeaderWriter(
				    		
				    		XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
				    
				    .and()
				    
				    	.formLogin()
				    	
				    	.loginPage("/user/login")
				    	
				    	.defaultSuccessUrl("/")
				    	
				    .and()	
				    
				    	.logout()
				    	
				    	.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				    	
				    	.logoutSuccessUrl("/")
				    	
				    	.invalidateHttpSession(true)
				    	
					;
			
			return http.build();
			
		}
		
		@Bean
		
		PasswordEncoder passwordEncoder() {
			
			return new BCryptPasswordEncoder() ;
		}

		@Bean
		 AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		 
		
			return authenticationConfiguration.getAuthenticationManager();

		}
		
}
