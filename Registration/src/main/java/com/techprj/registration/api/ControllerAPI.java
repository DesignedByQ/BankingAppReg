package com.techprj.registration.api;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.InputStreamResource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.techprj.registration.dto.FileDTO;
import com.techprj.registration.dto.RegDetailsDTO;
import com.techprj.registration.entity.File;
import com.techprj.registration.entity.RegDetails;
import com.techprj.registration.repo.FileRepo;
import com.techprj.registration.repo.RegDetailsRepo;
import com.techprj.registration.service.FileService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControllerAPI {
	
	@Autowired
	FileService fileService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RegDetailsRepo regDetailsRepo;

	@PostMapping(value = "/uploadcust", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<RegDetailsDTO> createCust(@RequestBody RegDetailsDTO regDetailsDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(fileService.saveCust(regDetailsDTO));
	
	}
	
	@GetMapping(value = "/{custid}/customerdetails", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<RegDetailsDTO> downloadDetails(@PathVariable("custid") Long custid) {		
		
		return ResponseEntity.status(HttpStatus.OK).body(fileService.getDetails(custid));
			
	}
	
	@GetMapping(value = "/{custid}/downloadimage", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<InputStreamResource> downloadImage(@PathVariable("custid") Long custid) {
		
		RegDetailsDTO rd = fileService.getDetails(custid);
		FileDTO imageData = rd.getFileDTO();
		
		if(imageData != null) {
			
			byte[] fileBytes = imageData.getFileData();
			
			InputStream inputStream = new ByteArrayInputStream(fileBytes);
		
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(imageData.getFileType()))
					.contentLength(fileBytes.length)
					.body(new InputStreamResource(inputStream));
			
		}
			
		return ResponseEntity.notFound().build();
		
	}
	

	
}
