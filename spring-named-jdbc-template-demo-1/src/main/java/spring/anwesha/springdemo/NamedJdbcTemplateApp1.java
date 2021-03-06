package spring.anwesha.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import spring.anwesha.springdemo.dao.OrganizationDao;
import spring.anwesha.springdemo.domain.Organization;

@Component
public class NamedJdbcTemplateApp1 {
	@Autowired
	private OrganizationDao dao;
	@Autowired
	private DaoUtils daoUtils;
	
	public void actionMethod() {
		
daoUtils.createSeedData(dao);
		
		//List Organizations
		List<Organization> orgs = dao.getAllOrganization();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);
		
		//Create a new organization record
		Organization org = new Organization("General Electric", 1978, "989898", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizationCount(dao.getAllOrganization(), daoUtils.createOperation);
		
		//get single organization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, "getOrganization");
		
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build **** awesome ** driving machines!");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);
		
		//Delete an org
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganization(), daoUtils.deleteOperation);
		
		//cleanup
		dao.cleanUp();
		daoUtils.printOrganizationCount(dao.getAllOrganization(), daoUtils.cleanupOperation);

		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("beans-cp.xml");
		NamedJdbcTemplateApp1 mainApp = ctx.getBean(NamedJdbcTemplateApp1.class);
		mainApp.actionMethod();
		
		//create the bean
		//OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		
		//create seed data
				
		//close the application context
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
