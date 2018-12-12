package com.anwesha.springdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anwesha.springdemo.service.RandomizerRequestScope;
import com.anwesha.springdemo.service.RandomizerSessionScope;

@Controller
public class ScopedController {

	@Autowired
	RandomizerRequestScope randomizerRequestScope;
	
	@Autowired
	RandomizerSessionScope randomizerSessionScope;
	
	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception{
		
		response.getWriter().write("***************************** requestScope ***************************** <br>");
		response.getWriter().write(" old number :"+ randomizerRequestScope.getRandomNumber()+"<br>");
		randomizerRequestScope.generateRandomNumber();
		response.getWriter().write("New Number: "+randomizerRequestScope.getRandomNumber()+"<br>");
		response.getWriter().write("object reference: "+randomizerRequestScope+"<br>");
		
		response.getWriter().write("***************************** sessionScope ***************************** <br>");
		response.getWriter().write(" old number :"+ randomizerSessionScope.getRandomNumber()+"<br>");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New Number: "+randomizerSessionScope.getRandomNumber()+"<br>");
		response.getWriter().write("object reference: "+randomizerSessionScope+"<br>");
		
	}
}
