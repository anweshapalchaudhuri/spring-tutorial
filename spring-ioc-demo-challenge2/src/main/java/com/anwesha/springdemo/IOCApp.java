package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class IOCApp {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans-challenge2.xml");
		
		//create the bean
		City city = (City) ctx.getBean("mycity");
		
		//invoke the company slogan via the bean
		city.cityName();
		
		//close the applicationcontext(container).
		
		((FileSystemXmlApplicationContext)ctx).close();
	}
	
}
