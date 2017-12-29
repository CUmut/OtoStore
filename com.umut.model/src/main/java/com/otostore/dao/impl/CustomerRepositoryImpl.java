package com.otostore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.CustomerRepository;
import com.otostore.model.Customer;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext /*
						 * ile EntityManager nesnesini inject edilmekte ve dao metodlarda
						 * kullaılmaktadır.
						 */
	private EntityManager entityManager; /*EntityManager:Veritabanı işlemlerinin yönetilmesinden sorumludur.*/

	@Override
	public void saveCustomer(Customer customer) {
		this.entityManager.persist(customer); /*save metodu yerine Jpa'da persist kullanılır*/

	}

	@Override
	public void deleteCustomer(Customer customer) {
		if (this.entityManager.contains(customer)) {
			this.entityManager.remove(customer);
		} else {
			Customer deleteCustomer = findCustomer(customer.getId());
			this.entityManager.remove(deleteCustomer);
		}

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = entityManager.merge(customer); /*Jpa'da update işlemi merge metodu üzerinden yapılır.*/
		this.entityManager.flush(); /*Flush:Entitymanager ile ilişkilendirilmiş olan tüm nesneler için sorguların çalıştırılmasını sağlar,fakat commit edilmez.*/
		return updatedCustomer;
	}

	@Override
	public Customer findCustomer(Long id) {
		if (id == null)
			return null;
		return entityManager.find(Customer.class, id); /*Find metodu ile Id nesnesine doğrudan erişebilmekteyiz.*/
	}

	@Override
	public List<Customer> findAllCustomers() {
		return entityManager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
	}

	@Override
	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {

		return entityManager.createNamedQuery("Customer.findAll", Customer.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
	}

	@Override
	public TypedQuery<Customer> findCustomersByProfileName(String profileName) {
		if (profileName == null || profileName.length() == 0)
			throw new IllegalArgumentException("The name argument is required");
		TypedQuery<Customer> typedQuery = entityManager.createNamedQuery("Customer.findByProfileName", Customer.class);
		typedQuery.setParameter("profileName", profileName);
		return typedQuery;
	}

	@Override
	public long countCustomers() {
		return entityManager.createNamedQuery("Customer.customerCount", Long.class).getSingleResult();
	}

}
