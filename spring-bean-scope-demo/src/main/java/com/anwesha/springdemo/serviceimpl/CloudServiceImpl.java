package com.anwesha.springdemo.serviceimpl;

import java.util.Random;

import com.anwesha.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	public String offerService(String companyName) {
	Random random = new Random();
	String service ="\n As a Organization, " + companyName + " Offers world class cloud computing infrastructure."+"\nThe annual income exceeds "+random.nextInt(revenue)+ "dollars.";
	return service;
	}

}
