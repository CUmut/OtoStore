package com.otostore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.otostore.model.Vehicle;

public interface VehicleRepository {

	void saveVehicle(Vehicle vehicle);

	void deleteVehicle(Vehicle vehicle);

	Vehicle updateVehicle(Vehicle vehicle);

	Vehicle findVehicle(Long id);

	List<Vehicle> findAllVehicles();

	List<Vehicle> findVehicleEntries(int firstResult, int maxResults);

	TypedQuery<Vehicle> findVehiclesByVendor(String vendorName);

	long countVehicles();

}
