package com.otostore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.VendorRepository;
import com.otostore.model.Vendor;

@Repository
@Transactional
public class VendorRepositoryImpl implements  VendorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void saveVendor(Vendor vendor) {
	this.entityManager.persist(vendor);
		
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		if(this.entityManager.contains(vendor)) {
			this.entityManager.remove(vendor);
		}else {
			Vendor deleteVendor = findVendor(vendor.getId());
			this.entityManager.remove(deleteVendor);
		}
		
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		Vendor updatedVendor = entityManager.merge(vendor);
		this.entityManager.flush();
		return updatedVendor;
	}

	@Override
	public Vendor findVendor(Long id) {
		if(id == null) 
		return null;
		return entityManager.find(Vendor.class, id);
	}

	@Override
	public List<Vendor> findAllVendors() {
		
		return entityManager.createNamedQuery("Vendor.findAll",Vendor.class).getResultList();
	}

	@Override
	public List<Vendor> findVEndorEntries(int firstResult, int maxResults) {
		return entityManager.createNamedQuery("Vendor.findAll",Vendor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Override
	public TypedQuery<Vendor> findVendorByVendorName(String vendorName) {
		if(vendorName == null || vendorName.length() == 0) throw new IllegalArgumentException("The name argument is required");
		TypedQuery<Vendor> typedQuery = entityManager.createNamedQuery("Vendor.vendorName",Vendor.class);
		typedQuery.setParameter("vendorName", vendorName);
		return typedQuery;
	}

	@Override
	public long countVendors() {
		return entityManager.createNamedQuery("Vendor.vendorCount", Long.class).getSingleResult();
	}

}
