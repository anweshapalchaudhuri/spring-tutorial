package spring.anwesha.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.anwesha.springdemo.dao.OrganizationDao;
import spring.anwesha.springdemo.domain.Organization;
@Service
public class DaoUtils {

	
	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";
	
	public void printOrganizations(List<Organization> orgs, String operation)
	{
		System.out.println("\n*************************** Printing organizations after "+ operation + "operation ****************");
		for(Organization org:orgs) {
			System.out.println(org);
		}
	}

	
	public void printOrganization(Organization org, String operation) {
		System.out.println("\n ************* printing organization after "+operation+" operation ***********\n"+org);
	}
	public void printSuccessFailure(String operation, boolean param) {
		if(param) {
			System.out.println("\n operation "+operation+"********** success ************");
		}
		else
			System.out.println("\n operation "+operation+"********** failure ************");
	}
	
	public void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Amazon",1994,"65656",8765,"Work hard, have fun, make history");
		Organization org2 = new Organization("BMW",1929,"645556",5501,"We build utimate driving machines");
		Organization org3 = new Organization("Google",1996,"57573",4567,"Dont be evil");
		
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0,org1);
		orgs.add(1,org2);
		orgs.add(2,org3);
		
		int createCount = 0;
		for(Organization org:orgs) {
			boolean isCreated = dao.create(org);
			if(isCreated) {
				createCount +=1;
			}
			System.out.println("created"+ createCount+"organization");
		}
		
	}

	public void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.print("\n ********************************* currently we have "+orgs.size()+" organizations after "+ operation+" operations "+"  ");
	}

}
