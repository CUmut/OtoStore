package com.otostore.service;

import java.util.List;

import com.otostore.model.Customer;

public interface CustomerService {
	
	void saveCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer findCustomer(Long id);
	List<Customer> findAllCustomers();
	List<Customer> findCustomerEntries(int firstResult,int maxResults);
	Customer findCustomerByProfileName(String profileName);
	long countCustomers();
	Customer loginCustomer(String profileName,String password);
	
}
