package com.techprj.registration.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.techprj.registration.dto.AddressDTO;
import com.techprj.registration.dto.FileDTO;
import com.techprj.registration.dto.RegDetailsDTO;
import com.techprj.registration.entity.Address;
import com.techprj.registration.entity.RegDetails;
import com.techprj.registration.repo.FileRepo;
import com.techprj.registration.repo.RegDetailsRepo;

@Service
public class FileService {
	
	@Autowired
	FileRepo fileRepo;
	
	@Autowired
	RegDetailsRepo regDetailsRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
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
	
//	public RegDetailsDTO storeFile(RegDetailsDTO regDetailsDTO) {
//		
//		//Normalize file name
//		String fileName = StringUtils.cleanPath(regDetailsDTO.getFileDTO().getOriginalFilename());
//		
//		try {
//			// Check if the file's name contains invalid characters
//			if(fileName.contains("..")) {
//				//throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//			}
//			
////			RegDetails cust1 = new RegDetails(regDetailsDTO.getUsername(), regDetailsDTO.getFirstname(),
////					regDetailsDTO.getMiddlename(), regDetailsDTO.getLastname(), regDetailsDTO.getDob(),
////					regDetailsDTO.getAddressDTO(), regDetailsDTO.getMobile(), regDetailsDTO.getEmail(), 
////					regDetailsDTO.getPassword(), regDetailsDTO.getApproved(), regDetailsDTO.getVerdict(), 
////					regDetailsDTO.getFileDTO());
//					
//			RegDetails cust = modelMapper.map(regDetailsDTO, RegDetails.class);
//			
//			RegDetails custSaved = regDetailsRepo.save(cust);
//			
//			RegDetailsDTO custdto = modelMapper.map(custSaved, RegDetailsDTO.class);
//			
//			return custdto;
//			
//		} 
//		
//		catch (IOException ex) {
//			//throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//		}
//		
//		return null;
//		
//	}
	

	
//	public RegDetails getDetails(Long fileId) throws FileNotFoundException {
//		return regDetailsRepo.findById(fileId)
//				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
//	}

}
