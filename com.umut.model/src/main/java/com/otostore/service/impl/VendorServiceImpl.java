package com.otostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.VendorRepository;
import com.otostore.model.Vendor;
import com.otostore.service.VendorService;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public void saveVendor(Vendor vendor) {
		vendorRepository.saveVendor(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		vendorRepository.deleteVendor(vendor);

	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return vendorRepository.updateVendor(vendor);
	}

	@Override
	public Vendor findVendor(Long id) {
		return vendorRepository.findVendor(id);
	}

	@Override
	public List<Vendor> findAllVendors() {
		
		return vendorRepository.findAllVendors();
	}

	@Override
	public List<Vendor> findVendorEntries(int firstResult, int maxResults) {
		return vendorRepository.findVEndorEntries(firstResult, maxResults);
	}

	@Override
	public Vendor findVendorByVendorName(String vendorName) {
		
		return vendorRepository.findVendorByVendorName(vendorName).getSingleResult();
	}

	@Override
	public long countVendors() {
		
		return vendorRepository.countVendors();
	}

	@Override
	public Vendor loginVendor(String vendorName, String password) {
		Vendor vendor = this.findVendorByVendorName(vendorName);
		if(vendor != null && vendor.getPassword().equals(password)) {
			return vendor;
		}
		return null;
	}

}
