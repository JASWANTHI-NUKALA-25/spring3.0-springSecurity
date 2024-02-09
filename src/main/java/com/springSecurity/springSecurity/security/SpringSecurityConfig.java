package com.springSecurity.springSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springSecurity.springSecurity.security.service.UserInfoUserDetailService;

@Configuration
public class SpringSecurityConfig {
	 @Bean
	    public static PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }


//	    @Bean
//	    public UserDetailsService userDetailsService(PasswordEncoder encoder){
//
//	        UserDetails jashu = User.builder()
//	                .username("jashu")
//	                .password(passwordEncoder().encode("password"))
//	                .roles("USER")
//	                .build();
//
//	        UserDetails admin = User.builder()
//	                .username("admin")
//	                .password(passwordEncoder().encode("admin"))
//	                .roles("ADMIN")
//	                .build();
//
//	        return new InMemoryUserDetailsManager(jashu, admin);
//	    }
	 
	 
	 @Bean
	    public UserDetailsService userDetailsService(){
		 
		 return new UserInfoUserDetailService();
	 }
	 
	 
	    
	    
	    @SuppressWarnings("removal")
	    @Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
	    return	http.csrf().disable()
	    		.authorizeHttpRequests(auth->{
//	    			auth.anyRequest().permitAll();
	    			auth.requestMatchers("/security/**").permitAll();
	    			auth.requestMatchers("/all") .authenticated();
	    		})
	    		.build();
	    }
	    
	   
	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	    	DaoAuthenticationProvider authenticationProvider =new DaoAuthenticationProvider();
	    	authenticationProvider.setUserDetailsService(userDetailsService());
	    	authenticationProvider.setPasswordEncoder(passwordEncoder());
	    	return authenticationProvider;
	    }
	    
	    
}
