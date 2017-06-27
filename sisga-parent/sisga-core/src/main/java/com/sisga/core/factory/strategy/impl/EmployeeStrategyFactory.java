package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.EmployeeActiveComplementor;
import com.sisga.core.business.complement.EmployeeCodeComplementor;
import com.sisga.core.business.complement.EmployeePhoneComplementor;
import com.sisga.core.business.complement.InsertDateComplementor;
import com.sisga.core.business.complement.ProviderActiveComplementor;
import com.sisga.core.business.complement.ProviderCodeComplementor;
import com.sisga.core.business.complement.ProviderPhoneComplementor;
import com.sisga.core.business.fieldsvalidator.EmployeeFieldsValidator;
import com.sisga.core.business.fieldsvalidator.EmployeeSearchValidator;
import com.sisga.core.business.fieldsvalidator.ProviderFieldsValidator;
import com.sisga.core.business.fieldsvalidator.ProviderSearchValidator;
import com.sisga.core.business.validator.EmployeeSalaryValidator;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author rafae
 *
 */
public class EmployeeStrategyFactory implements IEntityStrategyFactory < Employee > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap<>();

		Map < String, List < IStrategy > > rnsEmployee = new HashMap < String, List < IStrategy > >();

		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		rnsSave.add( new EmployeeActiveComplementor() );
		rnsSave.add( new EmployeeCodeComplementor() );
		rnsSave.add( new InsertDateComplementor() );
		rnsSave.add( new EmployeeSalaryValidator() );
		rnsSave.add( new EmployeePhoneComplementor() );
		rnsSave.add( new EmployeeFieldsValidator() );

		rnsUpdate.add( new EmployeeSalaryValidator() );
		rnsUpdate.add( new EmployeePhoneComplementor() );
		rnsUpdate.add( new EmployeeFieldsValidator() );

		rnsFind.add( new EmployeeSearchValidator() );

		// Insere as regras de neg�cio por opera��o
		rnsEmployee.put( EOperation.SAVE, rnsSave );
		rnsEmployee.put( EOperation.UPDATE, rnsUpdate );
		rnsEmployee.put( EOperation.DELETE, rnsDelete );
		rnsEmployee.put( EOperation.FIND, rnsFind );

		rns.put( Employee.class.getName(), rnsEmployee );
		return rns;
	}

}
