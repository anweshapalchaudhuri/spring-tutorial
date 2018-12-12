package com.anwesha.springdemo.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.anwesha.springdemo.service.BusinessService;
@Component("myorg")
public class Organization {
	@Value("${nameOfCompany}")
	private String companyName;
	@Value("${startUpYear}")
	private int yearOfIncorporation;
	@Value("${postCode}")
	private String postalCode;
	@Value("${empCount:22222}")
	private String employeeCount;
	@Value("${corporateSlogan}")
	private String slogan;
	private String missionStatement;
	@Autowired
	private Environment env;
	
	private BusinessService businessService;
	
	public Organization() {System.out.println("organization: default constructor invoked");}
	
	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("organization:setSlogan() invoked");
		
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

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
		missionStatement = env.getProperty("statement");
		return missionStatement + "and also"+slogan;
		
		 }
	
	public String corporateService() {return businessService.offerService(companyName);}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}

}
