package spring.anwesha.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import spring.anwesha.springdemo.domain.Organization;

public interface OrganizationDao {

	//set the data-source that will be required to create a connection to a database. 
	public void setDatasource(DataSource ds);
	//create a record in the organization table 
	public boolean create(Organization org);
	
	//Retrieve a single Organization
	public Organization getOrganization(Integer id);
	
	//Retrieve all organizations
	public List<Organization> getAllOrganization();
	
	//Delete an Organization from the Table
	public boolean delete(Organization org);
	//Update an Organization in the table
	public boolean update(Organization org);
	
	public void cleanUp();
	
}
