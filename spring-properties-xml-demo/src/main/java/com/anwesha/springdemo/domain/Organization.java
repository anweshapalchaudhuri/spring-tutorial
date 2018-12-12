package com.anwesha.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.anwesha.springdemo.service.BusinessService;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	@Value("${org.postalCode}")
	private String postalCode;
	private String employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	public Organization() {System.out.println("organization: default constructor invoked");}
	
	public String getSlogan() {
		return slogan;
	}

	@Autowired
	public void setSlogan(@Value("${org.slogan}")String slogan) {
		this.slogan = slogan;
		System.out.println("organization:setSlogan() invoked");
		
	}

	/*public BusinessService getBusinessService() {
		return businessService;
	}*/

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("organization:setBusinessService() invoked");
	}

	public Organization(String companyName, int yearOfIncorporation) {
		
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("organization:constructor invoked");
	}
	
	public void postConstruct() {
		System.out.println("organization: postConstruct method called");
	}
	
	public void preDestroy() {
		System.out.println("organization: preDestroy method called");
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("organization: setPostalCode method called");
	}

	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("organization: setEmployeeCount method called");
	}

	public String corporateSlogan() {
		System.out.println("organization: corporateSlogan method called");
		return slogan;
		
		 }
	
	public String corporateService() {return businessService.offerService(companyName);}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan + "]";
	}

}
