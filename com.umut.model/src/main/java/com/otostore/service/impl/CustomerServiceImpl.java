package com.otostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.CustomerRepository;
import com.otostore.model.Customer;
import com.otostore.service.CustomerService;

@Service
@Transactional/*Bu anotasyon ile sınıfa ait tüm metodlar transaction mekanizmasına dahildir.*/
public class CustomerServiceImpl implements CustomerService {

	@Autowired /*Bu anotasyon ile Dao katmanını/sınıfı inject ediyoruz.*/
	private CustomerRepository customerRepository;

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.saveCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.deleteCustomer(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}

	@Override
	public Customer findCustomer(Long id) {
		return customerRepository.findCustomer(id);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAllCustomers();
	}

	@Override
	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
		return customerRepository.findCustomerEntries(firstResult, maxResults);
	}

	@Override
	public Customer findCustomerByProfileName(String profileName) {

		return customerRepository.findCustomersByProfileName(profileName).getSingleResult();
	}

	@Override
	public long countCustomers() {

		return customerRepository.countCustomers();
	}

	@Override
	public Customer loginCustomer(String profileName, String password) {
		Customer customer = this.findCustomerByProfileName(profileName);
		if (customer != null && customer.getPassword().equals(password)) {
			return customer;
		}
		return null;
	}

}
