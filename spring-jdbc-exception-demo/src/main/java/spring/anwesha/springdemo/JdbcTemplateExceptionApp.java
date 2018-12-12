package spring.anwesha.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import spring.anwesha.springdemo.dao.OrganizationDao;
import spring.anwesha.springdemo.domain.Organization;

public class JdbcTemplateExceptionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("beans-cp.xml");
		//create the bean
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		List<Organization> orgs = null; 
				try {
					
					orgs = dao.getAllOrganization();
				}catch(BadSqlGrammarException bge) {
					
					System.out.println("Sub exception message :: "+bge.getMessage());
					System.out.println("Sub exception class :: "+bge.getClass());
					
				}
				catch(DataAccessException dae) {
					
					System.out.println("Sub exception message :: "+dae.getMessage());
					System.out.println("Sub exception class :: "+dae.getClass());
					
				}
		for(Organization org: orgs) {
			System.out.println(org);
		}
		//close the application context
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
