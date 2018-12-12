package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IOCApp2 {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan via the bean
		org.corporateSlogan();
		
		//close the applicationcontext(container).
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
