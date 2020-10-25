package com.kingsongenius.fleetapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kingsongenius.fleetapp.models.Location;


@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
