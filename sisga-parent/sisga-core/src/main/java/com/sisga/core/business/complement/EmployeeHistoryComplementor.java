package com.sisga.core.business.complement;

import java.util.Date;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.dao.impl.EmployeeOperationDAO;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.address.Address;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.EmployeeHistory;
import com.sisga.domain.employee.EmployeeOperation;
import com.sisga.domain.employee.filter.EmployeeHistoryFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class EmployeeHistoryComplementor extends Complementor < EmployeeHistory > {

	@Override
	public String complement( EmployeeHistory employeeHistory ) {
		msg = null;

		EmployeeHistoryFilter filter = new EmployeeHistoryFilter();
		filter.setCode( employeeHistory.getCode() );

		try {
			createHistory( employeeHistory, employeeHistory.getOperationCode() );
		} catch( Exception e ) {
			e.printStackTrace();
			msg = "Erro inesperado";
		}

		return msg;
	}

	private void createHistory( EmployeeHistory history, String operationCode ) throws Exception {
		Employee employee = history.getEmployee();
		history.setAddress( new Address() );
		history.setActive( employee.isActive() );
		history.getAddress().setCity( employee.getAddress().getCity() );
		history.setCode( employee.getCode() );
		history.setDescription( employee.getDescription() );
		history.setInsertDate( new Date() );
		history.setFirstName( employee.getFirstName() );
		history.setLastName( employee.getLastName() );
		history.getAddress().setNeighborhood( employee.getAddress().getNeighborhood() );
		history.getAddress().setNumber( employee.getAddress().getNumber() );
		history.setEmail( employee.getEmail() );
		history.setWorkcardNumber( employee.getWorkcardNumber() );
		history.setEmploymentDate( employee.getEmploymentDate() );
		history.setResignationDate( employee.getResignationDate() );
		history.setSalary( employee.getSalary() );

		// Identifica a operação
		EmployeeOperationDAO dao = new EmployeeOperationDAO();
		dao.setSession( SessionThreadLocal.getSession() );

		EmployeeOperation op = new EmployeeOperation();
		EmployeeOperation operation = null;

		op.setCode( operationCode );
		operation = dao.findByCode( op );

		history.setEmployeeOperation( operation );
	}
}