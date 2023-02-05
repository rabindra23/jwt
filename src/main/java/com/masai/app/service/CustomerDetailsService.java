package com.masai.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Customer;

@Service
public class CustomerDetailsService implements UserDetailsService {
	@Autowired
	CustomerService ser;
	UserDetails user = null;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer customer = ser.getCustomerByEmail(username);
		if (customer != null) {
			List<GrantedAuthority> auths = new ArrayList<>();
			auths.add(new SimpleGrantedAuthority(customer.getRole()));
			user = User.withUsername(customer.getEmail()).password(customer.getPassword())
					.authorities(customer.getRole()).build();
		}
		return user;
	}
}
