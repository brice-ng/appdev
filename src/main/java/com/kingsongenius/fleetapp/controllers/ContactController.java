package com.kingsongenius.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingsongenius.fleetapp.models.Contact;
import com.kingsongenius.fleetapp.services.ContactService;
import com.kingsongenius.fleetapp.services.CountryService;
import com.kingsongenius.fleetapp.services.StateService;


@Controller
public class ContactController {
	
	
	  @Autowired private StateService stateService;
	  
	  @Autowired private CountryService countryService;
	  
	  @Autowired private ContactService contactService;
	  
	
	
	@GetMapping("/contact")
	public String getContact(Model model) {
		
		  model.addAttribute("countries", countryService.getCountries());
		  model.addAttribute("states", stateService.getState());
		  model.addAttribute("contacts", contactService.findAll());
		
		return "contact";
	}
			 
	  
	  @RequestMapping("contacts/findById")	  
	  @ResponseBody 
	  public Optional<Contact> findById(Integer id) { 
		  
		  return contactService.findById(id); }
	  
	  //Add Contact
	  
	  @PostMapping("/contacts/addNew") 
	  public String addNew(Contact contact) {
		  
	  contactService.save(contact); 
	  return "redirect:/contact"; 
	  
	  }
	  
	  @RequestMapping(value="contacts/update", method = {RequestMethod.PUT,RequestMethod.GET})
	  public String update(Contact contact) {
		  
	  contactService.save(contact); 
	  return "redirect:/contact"; }
	  
	  
	  @RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	  public String delete(Integer id) {
		  
	  contactService.delete(id); 
	  return "redirect:/contacts";
	  
	  }
	 
}
