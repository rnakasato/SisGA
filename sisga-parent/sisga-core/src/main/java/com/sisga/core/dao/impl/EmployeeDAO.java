package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.filter.EmployeeFilter;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji 7 de mar de 2017 17 de mar de 2017 - find
 */
public class EmployeeDAO extends DomainSpecificEntityDAO<Employee> {
	private EmployeeFilter employeeFilter;

	@Override
	public List<Employee> find(AbstractDomainEntity entity) throws Exception {
		employeeFilter = (EmployeeFilter) entity;
		List<Employee> employeeList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT DISTINCT (e) FROM Employee e");
		jpql.append(" LEFT JOIN e.city ec ");
		jpql.append(" LEFT JOIN e.telephones et ");
		jpql.append(" WHERE 1=1 ");

		if (StringUtils.isNotEmpty(employeeFilter.getName())) {
			jpql.append(" AND (UPPER(e.firstname) LIKE :fname OR UPPER(e.lastname) LIKE :lname");
		}
		if (employeeFilter.getEmploymentDateInit() != null && employeeFilter.getEmploymentDateFinal() != null) {
			jpql.append(" AND e.employmentDate BETWEEN :initDate AND :finalDate ");
		}
		if( employeeFilter.getStatus().equals("ATIVO")){
			jpql.append( " AND e.active = true " );
		} else if( employeeFilter.getStatus().equals("INATIVO")){
			jpql.append( " AND e.active = false " );
		}
		
		Query query = session.createQuery(jpql.toString());

		if (StringUtils.isNotEmpty(employeeFilter.getName())) {
			query.setParameter("fname", employeeFilter.getName().toUpperCase());
		}
		if (StringUtils.isNotEmpty(employeeFilter.getName())) {
			query.setParameter("lname", employeeFilter.getName().toUpperCase());
		}
		if (employeeFilter.getEmploymentDateInit() != null) {
			query.setParameter("initDate", employeeFilter.getEmploymentDateInit());
		}
		if (employeeFilter.getEmploymentDateFinal() != null) {
			query.setParameter("finalDate", employeeFilter.getEmploymentDateFinal());
		}

		employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		List<Employee> employeeList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM Employee ");

		Query query = session.createQuery(jpql.toString());

		employeeList = query.getResultList();

		return employeeList;
	}

	public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAO();

		Session session = HibernateUtil.getSessionFactory().openSession();
		dao.setSession(session);

		List<Employee> list = dao.findAll();

		session.close();
		for (Employee domain : list) {
			System.out.println(domain.getSalary());
		}

		System.exit(0);
	}
}
