package com.anwesha.springdemo.serviceimpl;

import java.util.Random;

import com.anwesha.springdemo.service.RecruitmentService;

public class AgencyRecruitmentServiceImpl implements RecruitmentService {

	public String recruitmentEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		// TODO Auto-generated method stub
		Random random = new Random();
		String hiringFacts = "\n"+companyName+"'s "+ departmentName+" hired "+random.nextInt(numberOfRecruitments)+" employees "+ "using various agencies. ";
		return hiringFacts;
	}

}
