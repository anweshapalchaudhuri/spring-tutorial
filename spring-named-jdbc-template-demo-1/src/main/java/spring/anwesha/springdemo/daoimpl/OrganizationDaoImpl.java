package spring.anwesha.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import spring.anwesha.springdemo.dao.OrganizationDao;
import spring.anwesha.springdemo.domain.Organization;
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDatasource(DataSource datasource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		
	}
	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "Insert into Organization (company_name,year_of_incorporation,postal_code,employee_count,slogan)"
				             +"values (:companyName,:yearOfIncorporation,:postalCode,:employeeCount,:slogan) ";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams)==1;
		/*Object args[] = new Object[] {org.getCompanyName(),org.getYearOfIncorporation(),org.getPostalCode(),org.getEmployeeCount(),org.getSlogan()};
		
		return jdbcTemplate.update(sqlQuery,args)==1;*/
	}

	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID",id);
		String sqlQuery = "Select id, company_name, year_of_incorporation,postal_code,employee_count,slogan "+"from organization where id = :ID";
		//Object[] args = new Object[] {id};
		Organization org = namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganization() {
	String sqlQuery = "Select * from Organization";
	List<Organization> orgList = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
	return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "Delete from organization where ID = :id";
		//Object[] args = new Object[] {org.getId()};
		return namedParameterJdbcTemplate.update(sqlQuery,beanParams)==1;
	}

	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "Update organization SET slogan = :slogan where id=:id";
		//Object[] args=new Object[] {org.getSlogan(),org.getId()};
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	public void cleanUp() {
		 String sqlQuery = "Truncate table organization";
		 namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
		
	}

	

}
