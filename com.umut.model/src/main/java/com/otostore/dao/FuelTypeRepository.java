package com.otostore.dao;

import java.util.List;

import com.otostore.model.sub.FuelType;

public interface FuelTypeRepository {
	
	void saveFuelType(FuelType fuelType);
	FuelType findFuelType(Long id);
	List<FuelType>findAllFuelType();
	List<String>findAllFuel();
	
}
