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
import com.kingsongenius.fleetapp.repositories.CountryRepository;
import com.kingsongenius.fleetapp.services.CountryService;




/**
 * @author Brice
 *
 */
@Controller  
public class CountryController {
	
	@Autowired 
	private CountryService countryService;
	
	@GetMapping("/countries")
	public String getCountries(Model model) {
		
		List<Country> countrylist = countryService.getCountries();
		
		model.addAttribute("countries",countrylist);
		
		return "country";
	}
	
	
	@PostMapping("/countries/addnew")
	public String addnew(Country country) {
		
		countryService.save(country);
		
		return"redirect:/countries";
	}
	
	@RequestMapping("countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id) {
		
		return	countryService.findById(id);
		
	}
	
	 
	//@RequestMapping(value="countries/update",method= {RequestMethod.PUT,RequestMethod.GET})
	@PostMapping("/countries/update") 
	public String update(Country country) {
		
		countryService.save(country);
		
		return"redirect:/countries";
	} 
	
	
	//delete Country	method
	
	@RequestMapping(value="countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String Delete(Integer id) {
		
		countryService.delete(id);
		
		return"redirect:/countries";
	} 
	
	
	
	
	
	
	
	
}
