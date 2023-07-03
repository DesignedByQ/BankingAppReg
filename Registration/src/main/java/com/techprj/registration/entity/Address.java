package com.techprj.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressID;
	private String buildingNo;
	private String firstLine;
	private String secondLine;
	private String city;
	private String county;
	private String postCode;
	private String country;
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private RegDetails regDetails;
	
	public Address() {
		super();
	}

	public Address(Integer addressID, String buildingNo, String firstLine, String secondLine, String city,
			String county, String postCode, String country, RegDetails regDetails) {
		super();
		this.addressID = addressID;
		this.buildingNo = buildingNo;
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.city = city;
		this.county = county;
		this.postCode = postCode;
		this.country = country;
		this.regDetails = regDetails;
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public RegDetails getRegDetails() {
		return regDetails;
	}

	public void setRegDetails(RegDetails regDetails) {
		this.regDetails = regDetails;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", buildingNo=" + buildingNo + ", firstLine=" + firstLine
				+ ", secondLine=" + secondLine + ", city=" + city + ", county=" + county + ", postCode=" + postCode
				+ ", country=" + country + ", regDetails=" + regDetails + "]";
	}	

}

