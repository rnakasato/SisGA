package com.sisga.core.business.complement;

import java.math.BigInteger;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.employee.Employee;

public class EmployeePhoneComplementor extends Complementor<Employee> {

	@Override
	public String complement(Employee entity) {
		if (!entity.getTelephones().isEmpty()) {
			entity.getTelephones().get(0).setEmployee(entity);
			entity.getTelephones().get(1).setEmployee(entity);
			return null;
		}
		return ("Numeros de Telefones não informados");
	}

}
