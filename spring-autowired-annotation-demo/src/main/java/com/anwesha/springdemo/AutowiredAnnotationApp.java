package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anwesha.springdemo.domain.Organization;
import com.anwesha.springdemo.domain.promotion.TradeFair;


public class AutowiredAnnotationApp {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		TradeFair tradefair = (TradeFair)ctx.getBean("myfair");
		System.out.println(tradefair.specialPromotionalPricing());
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
