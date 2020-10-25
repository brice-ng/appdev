package com.kingsongenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.kingsongenius.fleetapp.models.Country;
import com.kingsongenius.fleetapp.models.Location;
import com.kingsongenius.fleetapp.models.State;
import com.kingsongenius.fleetapp.services.CountryService;
import com.kingsongenius.fleetapp.services.LocationService;
import com.kingsongenius.fleetapp.services.StateService;


@Controller
public class LocationController {
	

	@Autowired 
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private LocationService locationService;
	
	
	@GetMapping("/locations")
	public String getLocation(Model model) {
		
		
		
		
		List<Country> countrylist = countryService.getCountries();
		
		
		List<State> statelist = stateService.getState();
		
		
		List<Location> locationlist = locationService.getLocation();
		
		
		model.addAttribute("countries",countrylist);
		model.addAttribute("states",statelist);
		model.addAttribute("locations",locationlist);
		
		
		return "location";
	}
	
	
	@PostMapping("/locations/addnew")
	public String addnew(Location location) {
		
		locationService.save(location);
		
		return"redirect:/locations";
	}
	
	@RequestMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		
		return	locationService.findById(id);
		
	}
	
	
	//@RequestMapping(value="locations/update", method= {RequestMethod.PUT,RequestMethod.GET})
	@PostMapping("/locations/update")

	public String update(Location location) {
		
		locationService.save(location);
		
		return"redirect:/locations";
	} 
	

	
//delete State	method
	
	@RequestMapping(value="locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String Delete(Integer id) {
		
		locationService.deleteById(id);
		
		return"redirect:/locations";
	} 
	
}