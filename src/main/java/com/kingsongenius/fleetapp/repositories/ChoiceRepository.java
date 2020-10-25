package com.kingsongenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kingsongenius.fleetapp.models.Choice;
import com.kingsongenius.fleetapp.models.Country;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Integer> {

	
	
}
