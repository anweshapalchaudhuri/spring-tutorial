package spring.anwesha.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.anwesha.springdemo.dao.OrganizationDao;
import spring.anwesha.springdemo.domain.Organization;
@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDatasource(DataSource datasource) {
		 jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public boolean create(Organization org) {
		String sqlQuery = "Insert into Organization (company_name,year_of_incorporation,postal_code,employee_count,slogan)"
				             +"values (?,?,?,?,?) ";
		Object args[] = new Object[] {org.getCompanyName(),org.getYearOfIncorporation(),org.getPostalCode(),org.getEmployeeCount(),org.getSlogan()};
		
		return jdbcTemplate.update(sqlQuery,args)==1;
	}

	public Organization getOrganization(Integer id) {
		String sqlQuery = "Select id, company_name, year_of_incorporation,postal_code,employee_count,slogan "+"from organization where id = ?";
		Object[] args = new Object[] {id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganization() {
	String sqlQuery = "Select * from Organization";
	List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
	return orgList;
	}

	public boolean delete(Organization org) {
		String sqlQuery = "Delete from organization where id = ?";
		Object[] args = new Object[] {org.getId()};
		return jdbcTemplate.update(sqlQuery,args)==1;
	}

	public boolean update(Organization org) {
		String sqlQuery = "Update organization SET slogan =? where id=?";
		Object[] args=new Object[] {org.getSlogan(),org.getId()};
		return jdbcTemplate.update(sqlQuery, args)==1;
	}

	public void cleanUp() {
		 String sqlQuery = "Truncate table organization";
		 jdbcTemplate.execute(sqlQuery);
		
	}

	

}
