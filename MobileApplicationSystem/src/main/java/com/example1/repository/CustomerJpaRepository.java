package com.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.model.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer ,Integer>
{

}
