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

import com.kingsongenius.fleetapp.models.Client;
import com.kingsongenius.fleetapp.models.Country;
import com.kingsongenius.fleetapp.models.State;
import com.kingsongenius.fleetapp.services.ClientService;
import com.kingsongenius.fleetapp.services.CountryService;
import com.kingsongenius.fleetapp.services.StateService;



@Controller
public class ClientController {
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;	
	@Autowired private ClientService clientService;
	
	
	@GetMapping("/client")
	public String getClient(Model model) {
		
		List<Client> clientList = clientService.findAll();
		
		model.addAttribute("clients",clientList);
		
       List<State> statelist = stateService.getState();
		
		model.addAttribute("states",statelist);
		
        List<Country> countrylist = countryService.getCountries();
		
		model.addAttribute("countries",countrylist);
		
		
		//return the html file
		
		return "client";
	}
	

	@PostMapping("/client/addnew")
	public String addnew(Client client) {
		
		clientService.save(client);
		
		return"redirect:/client";
	}
	
	
	
	@RequestMapping("client/findById")
	@ResponseBody
	public Optional<Client> findById(int id) {
		
		return	clientService.findById(id);
		
	}
	
	 
	//@PostMapping("/client/update") 
	@RequestMapping(value="client/update", method= {RequestMethod.PUT , RequestMethod.GET})
	public String update(Client clients) {
		
		clientService.save(clients);
		
		return"redirect:/client";
	} 
	
	
	//delete Country	method
	
	@RequestMapping(value="client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String Delete(Integer id) {
		
		clientService.delete(id);
		
		return"redirect:/client";
		
	} 
	
	
	
}
