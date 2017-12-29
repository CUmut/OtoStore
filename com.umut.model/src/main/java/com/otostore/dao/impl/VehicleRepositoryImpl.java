package com.otostore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.otostore.dao.VehicleRepository;
import com.otostore.model.Vehicle;

@Repository
@Transactional
public class VehicleRepositoryImpl implements VehicleRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveVehicle(Vehicle vehicle) {
		this.entityManager.persist(vehicle);

	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {
		if (this.entityManager.contains(vehicle)) {
			this.entityManager.remove(vehicle);
		} else {
			Vehicle deleteVehicle = findVehicle(vehicle.getId());
			this.entityManager.remove(deleteVehicle);
		}

	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		Vehicle updateCar = entityManager.merge(vehicle);
		this.entityManager.flush();
		return updateCar;
	}

	@Override
	public Vehicle findVehicle(Long id) {
		if (id == null)
			return null;
		return entityManager.find(Vehicle.class, id);
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class).getResultList();

	}

	@Override
	public List<Vehicle> findVehicleEntries(int firstResult, int maxResults) {
		return entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
	}

	@Override
	public TypedQuery<Vehicle> findVehiclesByVendor(String vendorName) {
		if (vendorName == null || vendorName.length() == 0)
			throw new IllegalArgumentException("The name argument is required");
		TypedQuery<Vehicle> typedQuery = entityManager.createNamedQuery("Vehicle.findByVendorName", Vehicle.class);
		typedQuery.setParameter("vendorName", vendorName);
		return typedQuery;
	}

	@Override
	public long countVehicles() {
		return entityManager.createNamedQuery("Vehicle.vehicleCount", Long.class).getSingleResult();
	}

}
