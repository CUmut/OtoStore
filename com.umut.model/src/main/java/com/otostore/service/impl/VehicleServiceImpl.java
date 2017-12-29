package com.otostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.VehicleRepository;
import com.otostore.model.Vehicle;
import com.otostore.service.VehicleService;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.saveVehicle(vehicle);
		
	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {
		vehicleRepository.deleteVehicle(vehicle);
		
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleRepository.updateVehicle(vehicle);
	}

	@Override
	public Vehicle findVehicle(Long id) {
		
		return vehicleRepository.findVehicle(id);
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAllVehicles();
	}

	@Override
	public List<Vehicle> findVehicleEntries(int firstResult, int maxResults) {
		return vehicleRepository.findVehicleEntries(firstResult, maxResults);
	}

	@Override
	public List<Vehicle> findVehicleByVendor(String vendorName) {
		
		return vehicleRepository.findVehiclesByVendor(vendorName).getResultList();
	}

	@Override
	public long countVehicles() {
		return vehicleRepository.countVehicles();
	}

}
