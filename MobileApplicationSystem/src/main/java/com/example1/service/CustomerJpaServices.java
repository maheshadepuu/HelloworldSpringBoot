package com.example1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example1.model.Customer;
import com.example1.model.Mobile;
import com.example1.repository.CustomerJpaRepository;
import com.example1.repository.CustomerRepository;
@Service

public class CustomerJpaServices implements CustomerRepository
{

	@Autowired
	private CustomerJpaRepository customerJpaRepository;
	
	@Override
	public ArrayList<Customer> getCustomers() {
		List<Customer> customerList=customerJpaRepository.findAll();
		ArrayList<Customer> customers=new ArrayList<>(customerList);
		return customers;
	}
	@Override
	public Customer getCustomerById(int customerId) {
		try
		{
		Customer customer= customerJpaRepository.findById(customerId).get();
		return customer;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public Customer addCustomer(Customer customer) {
		customerJpaRepository.save(customer);
		 return customer;
	}
	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		try
		{
		Customer existingCustomer= customerJpaRepository.findById(customerId).get();
		if(customer.getName()!=null)
		{
			existingCustomer.setName(customer.getName());
		}
		 customerJpaRepository.save(existingCustomer);
		return existingCustomer;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public void deleteCustomer(int customerId) {
		try
		{
		Customer customer= customerJpaRepository.findById(customerId).get();
		if(customer!=null)
		{
			customerJpaRepository.deleteById(customerId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
}
