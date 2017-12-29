package com.otostore.service;

import java.util.List;

import com.otostore.model.Vendor;

public interface VendorService {
	
	void saveVendor(Vendor vendor);
	void deleteVendor(Vendor vendor);
	Vendor updateVendor(Vendor vendor);
	Vendor findVendor(Long id);
	List<Vendor> findAllVendors();
	List<Vendor> findVendorEntries(int firstResult,int maxResults);
	Vendor findVendorByVendorName(String vendorName);
	long countVendors();
	Vendor loginVendor(String vendorName,String password);
	
}
