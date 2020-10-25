 package com.kingsongenius.fleetapp.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.kingsongenius.fleetapp.models.Country;
import com.kingsongenius.fleetapp.repositories.CountryRepository;
import com.kingsongenius.fleetapp.services.ChoiceService;
import com.kingsongenius.fleetapp.services.CountryService;




/**
 * @author Brice
 *
 */
@Controller  
public class ExcelController {
	
	  @Autowired private ChoiceService choiceService;
		private String fileLocation;

	
	@GetMapping("/excel")
	public String getExcel(Model model) {
		
		return "excel";
	}
	
	 
	@PostMapping("/uploadExcelFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
	    InputStream in = file.getInputStream();
	    File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
	    FileOutputStream f = new FileOutputStream(fileLocation);
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();
	    model.addAttribute("message", "File: " + file.getOriginalFilename() 
	      + " has been uploaded successfully!");
	    
	    return "excel";
	}
	
	
	
	
	
	
}
