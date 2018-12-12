package com.anwesha.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService {
	
	public List<String> getWelcomeMessages(String name){
		
		List<String> myWelcomeMessages = new ArrayList<>();
		myWelcomeMessages.add("Hello !");
		myWelcomeMessages.add(name);
		myWelcomeMessages.add(", Welcome to the spring course :)");
		
		return myWelcomeMessages;
		
		
	}

}
