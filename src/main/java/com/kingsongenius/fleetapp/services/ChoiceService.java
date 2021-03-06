package com.kingsongenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingsongenius.fleetapp.models.Choice;
import com.kingsongenius.fleetapp.repositories.ChoiceRepository;


@Service
public class ChoiceService {

	@Autowired
	private ChoiceRepository choiceRepository;

	
	//return list of countries
	public List<Choice> getChoice(){
		
		return choiceRepository.findAll();
	}
	
	//save new country
	public void save (Choice choice) {
			
		choiceRepository.save(choice);
			
	}
	
	
	//get by Id 
	
	public Optional<Choice> findById(int id) {
		return choiceRepository.findById(id);
	}
	
	//delete country 
	public void delete(Integer id) {

		choiceRepository.deleteById(id);
	}

	
	
	
	 
	
	
	
	
	
}
