package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anwesha.springdemo.domain.Organization;


public class InitDestroyApp {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan via the bean
		//System.out.println(org.corporateSlogan());
		//print the Org details
		//System.out.println(org);
		//System.out.println(org.corporateService());
		//close the applicationcontext(container).
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
