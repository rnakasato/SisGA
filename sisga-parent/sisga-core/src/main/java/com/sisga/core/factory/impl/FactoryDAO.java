package com.sisga.core.factory.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.sisga.core.IDAO;
import com.sisga.core.dao.impl.CityDAO;
import com.sisga.core.dao.impl.CustomerDAO;
import com.sisga.core.dao.impl.CustomerHistoryDAO;
import com.sisga.core.dao.impl.CustomerOperationDAO;
import com.sisga.core.dao.impl.EmployeeDAO;
import com.sisga.core.dao.impl.EmployeeHistoryDAO;
import com.sisga.core.dao.impl.EmployeeOperationDAO;
import com.sisga.core.dao.impl.ProductDAO;
import com.sisga.core.dao.impl.ProductHistoryDAO;
import com.sisga.core.dao.impl.ProductOperationDAO;
import com.sisga.core.dao.impl.ProductionTypeDAO;
import com.sisga.core.dao.impl.ProviderDAO;
import com.sisga.core.dao.impl.ProviderHistoryDAO;
import com.sisga.core.dao.impl.ProviderOperationDAO;
import com.sisga.core.dao.impl.SaleTypeDAO;
import com.sisga.core.dao.impl.StateDAO;
import com.sisga.core.dao.impl.StockTypeDAO;
import com.sisga.core.dao.impl.UserDAO;
import com.sisga.core.dao.impl.UserHistoryDAO;
import com.sisga.core.dao.impl.UserOperationDAO;
import com.sisga.core.dao.impl.UserTypeDAO;
import com.sisga.domain.address.City;
import com.sisga.domain.address.State;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.filter.CustomerFilter;
import com.sisga.domain.customer.filter.CustomerHistoryFilter;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.EmployeeHistory;
import com.sisga.domain.employee.EmployeeOperation;
import com.sisga.domain.employee.filter.EmployeeFilter;
import com.sisga.domain.employee.filter.EmployeeHistoryFilter;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductHistory;
import com.sisga.domain.product.ProductOperation;
import com.sisga.domain.product.ProductionType;
import com.sisga.domain.product.SaleType;
import com.sisga.domain.product.StockType;
import com.sisga.domain.product.filter.ProductFilter;
import com.sisga.domain.product.filter.ProductHistoryFilter;
import com.sisga.domain.product.filter.ProductOperationFilter;
import com.sisga.domain.product.filter.ProductionTypeFilter;
import com.sisga.domain.product.filter.SaleTypeFilter;
import com.sisga.domain.product.filter.StockTypeFilter;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.ProviderHistory;
import com.sisga.domain.provider.ProviderOperation;
import com.sisga.domain.provider.filter.ProviderFilter;
import com.sisga.domain.provider.filter.ProviderHistoryFilter;
import com.sisga.domain.user.User;
import com.sisga.domain.user.UserHistory;
import com.sisga.domain.user.UserOperation;
import com.sisga.domain.user.UserType;
import com.sisga.domain.user.filter.UserFilter;

public class FactoryDAO {

	private static Map < String, IDAO > daoMap;

	private static void initMap() {
		if( daoMap == null ) {
			daoMap = new HashMap <>();

			// Product DAOs
			daoMap.put( Product.class.getName(), new ProductDAO() );
			daoMap.put( ProductFilter.class.getName(), new ProductDAO() );

			daoMap.put( ProductionType.class.getName(), new ProductionTypeDAO() );
			daoMap.put( ProductionTypeFilter.class.getName(), new ProductionTypeDAO() );

			daoMap.put( ProductOperation.class.getName(), new ProductOperationDAO() );
			daoMap.put( ProductOperationFilter.class.getName(), new ProductOperationDAO() );

			daoMap.put( SaleType.class.getName(), new SaleTypeDAO() );
			daoMap.put( SaleTypeFilter.class.getName(), new SaleTypeDAO() );

			daoMap.put( StockType.class.getName(), new StockTypeDAO() );
			daoMap.put( StockTypeFilter.class.getName(), new StockTypeDAO() );

			daoMap.put( ProductHistory.class.getName(), new ProductHistoryDAO() );
			daoMap.put( ProductHistoryFilter.class.getName(), new ProductHistoryDAO() );

			// Provider DAOs
			daoMap.put( Provider.class.getName(), new ProviderDAO() );
			daoMap.put( ProviderFilter.class.getName(), new ProviderDAO() );
			daoMap.put( ProviderOperation.class.getName(), new ProviderOperationDAO() );
			daoMap.put( ProviderHistory.class.getName(), new ProviderHistoryDAO() );
			daoMap.put( ProviderHistoryFilter.class.getName(), new ProviderHistoryDAO() );

			// Customer DAOs
			daoMap.put( Customer.class.getName(), new CustomerDAO() );
			daoMap.put( CustomerFilter.class.getName(), new CustomerDAO() );
			daoMap.put( CustomerOperation.class.getName(), new CustomerOperationDAO() );
			daoMap.put( CustomerHistory.class.getName(), new CustomerHistoryDAO() );
			daoMap.put( CustomerHistoryFilter.class.getName(), new CustomerHistoryDAO() );

			// Employee DAOs
			daoMap.put( Employee.class.getName(), new EmployeeDAO() );
			daoMap.put( EmployeeFilter.class.getName(), new EmployeeDAO() );
			daoMap.put( EmployeeOperation.class.getName(), new EmployeeOperationDAO() );
			daoMap.put( EmployeeHistory.class.getName(), new EmployeeHistoryDAO() );
			daoMap.put( EmployeeHistoryFilter.class.getName(), new EmployeeHistoryDAO() );

			// City State DAOs
			daoMap.put( State.class.getName(), new StateDAO() );
			daoMap.put( City.class.getName(), new CityDAO() );

			// User DAOs
			daoMap.put( User.class.getName(), new UserDAO() );
			daoMap.put( UserFilter.class.getName(), new UserDAO() );			
			daoMap.put( UserOperation.class.getName(), new UserOperationDAO() );
			daoMap.put( UserHistory.class.getName(), new UserHistoryDAO() );
			daoMap.put( UserType.class.getName(), new UserTypeDAO() );

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
