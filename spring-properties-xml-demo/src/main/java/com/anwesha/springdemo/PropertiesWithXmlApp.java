package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anwesha.springdemo.domain.Organization;
import com.anwesha.springdemo.domain.promotion.TradeFair;


public class PropertiesWithXmlApp {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		Organization organization = (Organization)ctx.getBean("myorg");
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
