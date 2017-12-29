package com.otostore.service;

import java.util.List;

import com.otostore.model.sub.FuelType;

public interface FuelTypeService {
	
	void saveFuelType(FuelType fuelType);
	FuelType findFuelType(Long id);
	List<FuelType> findAllFuelType();
	List<String> findAllFuel();
	
}
