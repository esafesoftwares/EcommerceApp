package com.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
//@EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
//@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  MyDBAuthenticationService myDBAauthenticationService;
  @Autowired
  DbAuthenticationCustomer customerAuthentication;
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

      // For User in database.
     auth.userDetailsService(myDBAauthenticationService);
      auth.userDetailsService(customerAuthentication);
  }
  
  protected void configure(HttpSecurity http) throws Exception {
	 //web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
      http.csrf().disable();

      // The pages requires login as EMPLOYEE or MANAGER.
      // If no login, it will redirect to /login page.
      http.authorizeRequests().antMatchers("/productList", "/accountInfo")//
              .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER','USER')");

      // For MANAGER only.
      http.authorizeRequests().antMatchers("/admin/" ).access("hasRole('ROLE_MANAGER')");
      //For Customer Only.
     
      // When the user has logged in as XX.
      // But access a page that requires role YY,
      // AccessDeniedException will throw.
      http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

      // Config for Login Form
      http.authorizeRequests().and().formLogin()//
              // Submit URL of login page.
              .loginProcessingUrl("/j_spring_security_check") // Submit URL
              .loginPage("/login")//
              .defaultSuccessUrl("/accountInfo")//
              .failureUrl("/login?error=true")//
              .usernameParameter("userName")//
              .passwordParameter("password")
              // Config for Logout Page
              // (Go to home page).
              .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

  }
  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
 
  /*@Bean
  public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
      StrictHttpFirewall fireWall = new StrictHttpFirewall();
      fireWall.setAllowUrlEncodedSlash(true); 
      ArrayList<String> allowed = new ArrayList<>();
      allowed.add("GET");
      allowed.add("POST");
      fireWall.setAllowedHttpMethods(allowed);
      fireWall.setUnsafeAllowAnyHttpMethod(true);
      return fireWall;
  }
  @Override
  public void configure(WebSecurity web) throws Exception {
  // add it 
  web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
  }*/

}