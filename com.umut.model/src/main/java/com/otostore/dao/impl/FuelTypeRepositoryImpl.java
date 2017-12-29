package com.otostore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.FuelTypeRepository;
import com.otostore.model.sub.FuelType;

@Repository
@Transactional
public class FuelTypeRepositoryImpl implements FuelTypeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveFuelType(FuelType fuelType) {
		this.entityManager.persist(fuelType);

	}

	@Override
	public FuelType findFuelType(Long id) {
		if (id == null)
			return null;
		return entityManager.find(FuelType.class, id);
	}

	@Override
	public List<FuelType> findAllFuelType() {

		return entityManager.createNamedQuery("FuelType.findAll", FuelType.class).getResultList();
	}

	@Override
	public List<String> findAllFuel() {
		return entityManager.createNamedQuery("FuelType.findFuels", String.class).getResultList();
	}

}
