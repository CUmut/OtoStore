package com.otostore.service;

import java.util.List;

import com.otostore.model.Vehicle;

public interface VehicleService {
	
	void saveVehicle(Vehicle vehicle);
	void deleteVehicle(Vehicle vehicle);
	Vehicle updateVehicle(Vehicle vehicle);
	Vehicle findVehicle(Long id);
	List<Vehicle> findAllVehicles();
	List<Vehicle> findVehicleEntries(int firstResult,int maxResults);
	List<Vehicle> findVehicleByVendor(String vendorName);
	long countVehicles();
	
}
