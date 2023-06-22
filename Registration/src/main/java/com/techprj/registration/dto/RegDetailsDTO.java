package com.techprj.registration.dto;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class RegDetailsDTO {
	
	private Long custid;
	private String account;
	private String username;
	private String firstname;
	private String middlename;
	private String lastname;
	private LocalDate dob;
	private AddressDTO addressDTO;
	private Long mobile;
	private String email;
	private String password;
	private Boolean approved;
	private String verdict;
	private FileDTO fileDTO;
	
	public RegDetailsDTO() {
		super();
	}

	public RegDetailsDTO(Long custid, String account, String username, String firstname, String middlename,
			String lastname, LocalDate dob, AddressDTO addressDTO, Long mobile, String email, String password,
			Boolean approved, String verdict, FileDTO fileDTO) {
		super();
		this.custid = custid;
		this.account = account;
		this.username = username;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.addressDTO = addressDTO;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.approved = approved;
		this.verdict = verdict;
		this.fileDTO = fileDTO;
	}

	public Long getCustid() {
		return custid;
	}

	public void setCustid(Long custid) {
		this.custid = custid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

	public FileDTO getFileDTO() {
		return fileDTO;
	}

	public void setFileDTO(FileDTO fileDTO) {
		this.fileDTO = fileDTO;
	}

	@Override
	public String toString() {
		return "RegDetailsDTO [custid=" + custid + ", account=" + account + ", username=" + username + ", firstname="
				+ firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", dob=" + dob + ", addressDTO="
				+ addressDTO + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", approved="
				+ approved + ", verdict=" + verdict + ", fileDTO=" + fileDTO + "]";
	}
			
}
