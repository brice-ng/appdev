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
import com.kingsongenius.fleetapp.models.Invoice;
import com.kingsongenius.fleetapp.models.State;
import com.kingsongenius.fleetapp.services.ClientService;
import com.kingsongenius.fleetapp.services.CountryService;
import com.kingsongenius.fleetapp.services.InvoiceService;
import com.kingsongenius.fleetapp.services.InvoiceStatusService;
import com.kingsongenius.fleetapp.services.StateService;


@Controller
public class InvoiceController {
	
	@Autowired private InvoiceService invoiceService;
	@Autowired private CountryService countryService;	
	@Autowired private ClientService clientService;
	
	@GetMapping("/invoice")
	public String getInvoice(Model model) {
		
	  List<Client> clientList = clientService.findAll();
		
		model.addAttribute("clients",clientList);
		
       List<Invoice> invoicelist = invoiceService.findAll();
		
		model.addAttribute("invoices",invoicelist);
		
   
		
		return "invoice";
	}
	

	@PostMapping("/invoice/addnew")
	public String addnew(Invoice invoice) {
		
		invoiceService.save(invoice);
		
		return"redirect:/invoice";
	}
	
	@RequestMapping("invoice/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {
		
		return	invoiceService.findById(id);
		
	}
	
	 
	//@RequestMapping(value="invoice/update", method = {RequestMethod.DELETE, RequestMethod.GET})	
	@PostMapping("/invoice/update") 
	public String update(Invoice invoice) {
		
		invoiceService.save(invoice);
		
		return"redirect:/invoice";
	} 
	
	
	//delete Country	method
	
	@RequestMapping(value="invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String Delete(Integer id) {
		
		invoiceService.delete(id);
		
		return"redirect:/invoice";
	} 
	
	
	
	
	
}
