package com.otostore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.otostore.model.Customer;

public interface CustomerRepository {

	void saveCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer findCustomer(Long id);

	List<Customer> findAllCustomers();

	List<Customer> findCustomerEntries(int firstResult, int maxResults);

	TypedQuery<Customer> findCustomersByProfileName(String profileName);

	long countCustomers();

}
