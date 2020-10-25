package com.kingsongenius.fleetapp.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kingsongenius.fleetapp.models.Users;

public interface ReadFileService {

	List<Users> findAll();

	 boolean saveDataFromUploadfile(MultipartFile file);
	 

}
