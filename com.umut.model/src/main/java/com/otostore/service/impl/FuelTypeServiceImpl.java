package com.otostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.FuelTypeRepository;
import com.otostore.model.sub.FuelType;
import com.otostore.service.FuelTypeService;

@Service
@Transactional
public class FuelTypeServiceImpl implements  FuelTypeService {
	
	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	@Override
	public void saveFuelType(FuelType fuelType) {
		fuelTypeRepository.saveFuelType(fuelType);
		
	}

	@Override
	public FuelType findFuelType(Long id) {
		return fuelTypeRepository.findFuelType(id);
	}

	@Override
	public List<FuelType> findAllFuelType() {
		return fuelTypeRepository.findAllFuelType();
	}

	@Override
	public List<String> findAllFuel() {
		return fuelTypeRepository.findAllFuel();
	}

}
