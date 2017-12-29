package com.otostore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.otostore.model.Vendor;

public interface VendorRepository {

	void saveVendor(Vendor vendor);

	void deleteVendor(Vendor vendor);

	Vendor updateVendor(Vendor vendor);

	Vendor findVendor(Long id);

	List<Vendor> findAllVendors();

	List<Vendor> findVEndorEntries(int firstResult, int maxResults);

	TypedQuery<Vendor> findVendorByVendorName(String vendorName);

	long countVendors();
}
