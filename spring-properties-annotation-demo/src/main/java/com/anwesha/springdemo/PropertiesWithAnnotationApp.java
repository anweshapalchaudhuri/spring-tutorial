package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anwesha.springdemo.domain.Organization;
import com.anwesha.springdemo.domain.promotion.TradeFair;


public class PropertiesWithAnnotationApp {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Organization org = (Organization)ctx.getBean("myorg");
		
		System.out.println(org);
		System.out.println("slogan----   "+org.corporateSlogan());
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
