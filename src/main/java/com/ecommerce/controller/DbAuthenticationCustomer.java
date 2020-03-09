package com.ecommerce.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;
@Service
public class DbAuthenticationCustomer implements UserDetailsService  {
	@Autowired
	private CustomerDao userDao;
	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
		Customer user = userDao.findCustomer(phonenumber);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		user.setPassword(encoder.encode(user.getPassword()));
		return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	

}
