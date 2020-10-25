package com.kingsongenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kingsongenius.fleetapp.models.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
