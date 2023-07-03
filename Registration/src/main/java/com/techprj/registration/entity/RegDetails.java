package com.techprj.registration.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techprj.registration.dto.AddressDTO;
import com.techprj.registration.dto.FileDTO;

@Entity
@Table(name="details")
public class RegDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer custid;
	private String account;
	private String username;
	private String firstname;
	private String middlename;
	private String lastname;
	private LocalDate dob;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @JsonIgnore
	private Address address;
    @Column(unique = true)
    private Long mobile;
    @Column(unique = true)
	private String email;
	private String password;
	private boolean approved;
	private boolean rejected;
	private String verdict;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
	private File file;
	
    public RegDetails() {
		super();
	}

	public RegDetails(Integer custid, String account, String username, String firstname, String middlename,
			String lastname, LocalDate dob, Address address, Long mobile, String email, String password,
			boolean approved, boolean rejected, String verdict, File file) {
		super();
		this.custid = custid;
		this.account = account;
		this.username = username;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.approved = approved;
		this.rejected = rejected;
		this.verdict = verdict;
		this.file = file;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "RegDetails [custid=" + custid + ", account=" + account + ", username=" + username + ", firstname="
				+ firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", dob=" + dob + ", address="
				+ address + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", approved="
				+ approved + ", rejected=" + rejected + ", verdict=" + verdict + ", file=" + file + "]";
	}
	
}
