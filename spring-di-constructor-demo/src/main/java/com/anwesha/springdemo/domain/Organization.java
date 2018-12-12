package com.anwesha.springdemo.domain;

import com.anwesha.springdemo.service.BusinessService;

public class Organization {
	
	public String getCompanyName() {
		return companyName;
	}

	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private String employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	//public Organization() {}
	
	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public Organization(String companyName, int yearOfIncorporation) {
		
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String corporateSlogan() {
		return slogan;
		 }
	
	public String corporateService() {return businessService.offerService(companyName);}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}

}
