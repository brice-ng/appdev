package com.kingsongenius.fleetapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kingsongenius.fleetapp.models.Users;

@Repository
public interface ReadFileRepository extends CrudRepository<Users, Long> {

	
	
	
}
