package com.techprj.registration.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.techprj.registration.dto.AddressDTO;
import com.techprj.registration.dto.FileDTO;
import com.techprj.registration.dto.RegDetailsDTO;
import com.techprj.registration.entity.Address;
import com.techprj.registration.entity.RegDetails;
import com.techprj.registration.repo.FileRepo;
import com.techprj.registration.repo.RegDetailsRepo;

@Service
@Transactional
public class FileService {
	
	@Autowired
	FileRepo fileRepo;
	
	@Autowired
	RegDetailsRepo regDetailsRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	public RegDetailsDTO saveCust(RegDetailsDTO regDetailsDTO) {
		
		//System.out.println(regDetailsDTO.getAddressDTO());
		
		regDetailsDTO.getAddressDTO().setCountry("United Kingdom");
		
		RegDetails cust = modelMapper.map(regDetailsDTO, RegDetails.class);
		
		Address a = modelMapper.map(regDetailsDTO.getAddressDTO(), Address.class);
		cust.setAddress(a);
		//System.out.println(cust.getAddress());
		
		//RegDetails cust = regDetailsRepo.saveAndFlush(modelMapper.map(regDetailsDTO, RegDetails.class));
		
		RegDetails custSaved = regDetailsRepo.save(cust);
		
		RegDetailsDTO custdto = modelMapper.map(custSaved, RegDetailsDTO.class);
		
		AddressDTO addto = modelMapper.map(custSaved.getAddress(), AddressDTO.class);
		FileDTO fdto = modelMapper.map(custSaved.getFile(), FileDTO.class);
		
		custdto.setAddressDTO(addto);
		custdto.setFileDTO(fdto);
		
		return custdto;
	}
	
	public RegDetailsDTO getDetails(Long custid) {
		
		//System.out.println(".....................");
		
		Optional<RegDetails> rd = regDetailsRepo.findById(custid);
		
		//System.out.println(rd.get().getFile());
		
		FileDTO fdto = modelMapper.map(rd.get().getFile(), FileDTO.class);
		
		AddressDTO adto = modelMapper.map(rd.get().getAddress(), AddressDTO.class);
		
		RegDetailsDTO rddto = modelMapper.map(rd.get(), RegDetailsDTO.class);
		
		rddto.setFileDTO(fdto);
		rddto.setAddressDTO(adto);

		return rddto;
		
	}
	
	public List<RegDetailsDTO> getApplications() {
		
		List<RegDetails> rd = regDetailsRepo.findAll();
		
		List<RegDetailsDTO> dtolist = new ArrayList();
		
		for(RegDetails dets: rd) {
			
			if(dets.isApproved() == false) {
				
				FileDTO fdto = modelMapper.map(dets.getFile(), FileDTO.class);
				
				AddressDTO adto = modelMapper.map(dets.getAddress(), AddressDTO.class);
				
				RegDetailsDTO rddto = modelMapper.map(dets, RegDetailsDTO.class);
				
				rddto.setFileDTO(fdto);
				rddto.setAddressDTO(adto);
	
				dtolist.add(rddto);
			}
		}

		return dtolist;
	}
	
	public String deleteApplication(String email) {
		
		Optional<RegDetails> rd = regDetailsRepo.findByEmail(email);
		
		regDetailsRepo.deleteByEmail(email);
		
		return "Account with customer ID: " + rd.get().getCustid() + " and email: " + email + " is now set up as a customer";
		
	}
	
	public RegDetailsDTO setAsApproved(String email, Map<Object, Object> fields) {
		
	    Optional<RegDetails> rd = regDetailsRepo.findByEmail(email);

	    if (rd.isPresent()) {
	    	
	        RegDetailsDTO rddto = modelMapper.map(regDetailsRepo.save(rd.get()), RegDetailsDTO.class);

	        fields.forEach((key, value) -> {
	        	
	        	Field field1 = ReflectionUtils.findRequiredField(RegDetails.class, (String) key);
	        	field1.setAccessible(true);
	        	ReflectionUtils.setField(field1, rd.get(), value);
	        	
	        });
	        
	        RegDetails updatedCust = regDetailsRepo.save(rd.get());
	        
	        //use this to send a get req to email serice with the email and verdict from udated cust
	        Boolean confirmation = restTemplate.postForObject("http://localhost:8080/api/email/{email}", updatedCust, Boolean.class, updatedCust.getEmail());
	        
	        if(confirmation)
	        	
	        	return modelMapper.map(updatedCust, RegDetailsDTO.class);
	        
	    }

	    return null;
	    
	}

	
//	public RegDetails getDetails(Long fileId) throws FileNotFoundException {
//		return regDetailsRepo.findById(fileId)
//				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
//	}

}
