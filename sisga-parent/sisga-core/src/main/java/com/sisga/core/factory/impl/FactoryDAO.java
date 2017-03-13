package com.sisga.core.factory.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.sisga.core.IDAO;
import com.sisga.core.dao.impl.CustomerDAO;
import com.sisga.core.dao.impl.CustomerOperationDAO;
import com.sisga.core.dao.impl.CustomerStatusDAO;
import com.sisga.core.dao.impl.EmployeeDAO;
import com.sisga.core.dao.impl.EmployeeOperationDAO;
import com.sisga.core.dao.impl.ProductDAO;
import com.sisga.core.dao.impl.ProductOperationDAO;
import com.sisga.core.dao.impl.ProductionTypeDAO;
import com.sisga.core.dao.impl.ProviderDAO;
import com.sisga.core.dao.impl.ProviderOperationDAO;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.CustomerStatus;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.EmployeeOperation;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductOperation;
import com.sisga.domain.product.ProductionType;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.ProviderOperation;

public class FactoryDAO {

	private static Map < Class, IDAO > daoMap;

	private static void initMap() {
		if( daoMap == null ) {
			daoMap = new HashMap<>();
			daoMap.put( Product.class, new ProductDAO() );
			daoMap.put( ProductionType.class, new ProductionTypeDAO() );
			daoMap.put( ProductOperation.class, new ProductOperationDAO() );
			
			daoMap.put( Provider.class, new ProviderDAO() );
			daoMap.put( ProviderOperation.class, new ProviderOperationDAO() );
			
			
			daoMap.put( Customer.class, new CustomerDAO() );
			daoMap.put( CustomerOperation.class, new CustomerOperationDAO() );
			daoMap.put( CustomerStatus.class, new CustomerStatusDAO() );
			
			daoMap.put( Employee.class, new EmployeeDAO() );
			daoMap.put( EmployeeOperation.class, new EmployeeOperationDAO() );
		}
	}

	/**
	 * @param className
	 * @return retorna instância de DAO para o Objeto
	 */
	public static IDAO build( String className, Session session ) throws ClassNotFoundException {
		initMap();
		IDAO dao = daoMap.get( className );
		dao.setSession( session );
		if( dao == null ) {
			throw new ClassNotFoundException();
		}
		return dao;
	}
}
