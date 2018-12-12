package com.anwesha.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anwesha.springdemo.domain.HumanResourceDept;
import com.anwesha.springdemo.domain.Organization;


public class DIConstructorApp {

	public static void main(String[] args) {
		//create the application context(Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan via the bean
		System.out.println(org.corporateSlogan());
		//print the Org details
		/*System.out.println(org);
		System.out.println(org.corporateService());*/
		HumanResourceDept hrdpt = (HumanResourceDept)ctx.getBean("myhrdept");
		System.out.println(hrdpt.hiringStatus(5500));
		//close the applicationcontext(container).
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
