package com.kingsongenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingsongenius.fleetapp.models.Country;
import com.kingsongenius.fleetapp.models.State;
import com.kingsongenius.fleetapp.services.CountryService;
import com.kingsongenius.fleetapp.services.StateService;




@Controller
public class StateController {
	
	@Autowired 
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	
	@GetMapping("/states")
	public String getStates(Model model) {
		
		List<State> statelist = stateService.getState();
		
		model.addAttribute("states",statelist);
		
		
		List<Country> countrylist = countryService.getCountries();
		
		model.addAttribute("countries",countrylist);
		
		return "state";
	}
	
	
	@PostMapping("/states/addnew")
	public String addnew(State state) {
		
		stateService.save(state);
		
		return"redirect:/states";
	}
	
	
	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
		
		return	stateService.findById(id);
		
	}
	
	 
	@RequestMapping(value="states/update",method= {RequestMethod.PUT,RequestMethod.GET})
//	@PostMapping("/countries/update") 
	public String update(State state) {
		
		stateService.save(state);
		
		return"redirect:/states";
	} 
	
	
	
//delete State	method
	
	@RequestMapping(value="states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String Delete(Integer id) {
		
		stateService.delete(id);
		
		return"redirect:/states";
	} 
	
	
	
	
	
	
}
