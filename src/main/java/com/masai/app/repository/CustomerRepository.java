package com.masai.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByEmail(String email);
}
