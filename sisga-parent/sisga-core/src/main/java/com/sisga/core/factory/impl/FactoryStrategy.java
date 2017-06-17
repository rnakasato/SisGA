package com.sisga.core.factory.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.CustomerActiveComplementor;
import com.sisga.core.business.complement.CustomerCodeComplementor;
import com.sisga.core.business.complement.CustomerHistoryComplementor;
import com.sisga.core.business.complement.CustomerPhoneComplementor;
import com.sisga.core.business.complement.EmployeeActiveComplementor;
import com.sisga.core.business.complement.EmployeeCodeComplementor;
import com.sisga.core.business.complement.EmployeeHistoryComplementor;
import com.sisga.core.business.complement.EmployeePhoneComplementor;
import com.sisga.core.business.complement.InsertDateComplementor;
import com.sisga.core.business.complement.ProductActiveComplementor;
import com.sisga.core.business.complement.ProductCodeComplementor;
import com.sisga.core.business.complement.ProductHistoryComplementor;
import com.sisga.core.business.complement.ProductSaleTypeComplementor;
import com.sisga.core.business.complement.ProviderActiveComplementor;
import com.sisga.core.business.complement.ProviderCodeComplementor;
import com.sisga.core.business.complement.ProviderHistoryComplementor;
import com.sisga.core.business.complement.ProviderPhoneComplementor;
import com.sisga.core.business.fieldsvalidator.CustomerFieldsValidator;
import com.sisga.core.business.fieldsvalidator.CustomerSearchValidator;
import com.sisga.core.business.fieldsvalidator.EmployeeFieldsValidator;
import com.sisga.core.business.fieldsvalidator.EmployeeSearchValidator;
import com.sisga.core.business.fieldsvalidator.ProductFieldsValidator;
import com.sisga.core.business.fieldsvalidator.ProviderFieldsValidator;
import com.sisga.core.business.fieldsvalidator.ProviderSearchValidator;
import com.sisga.core.business.validator.EmployeeSalaryValidator;
import com.sisga.core.business.validator.ProductAmountValidator;
import com.sisga.core.business.validator.ProductBaseValueValidator;
import com.sisga.core.enums.EOperation;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.EmployeeHistory;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductHistory;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.ProviderHistory;

public class FactoryStrategy {

	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade;
	 * O valor é um mapa que de regras de negócio indexado pela operação A
	 * Chave é o nome da entidade referente às regras de negóio e o valor é
	 * um mapa contendo todos os Strategies referentes a cada operação
	 * (salvar,alterar,consultar,excluir)
	 */
	private static Map<String, Map<String, List<IStrategy>>> rns;
	private static Map<String, List<IStrategy>> rnsProduct;
	private static Map<String, List<IStrategy>> rnsProductHistory;
	private static Map<String, List<IStrategy>> rnsCustomer;
	private static Map<String, List<IStrategy>> rnsCustomerHistory;
	private static Map<String, List<IStrategy>> rnsEmployee;
	private static Map<String, List<IStrategy>> rnsEmployeeHistory;
	private static Map<String, List<IStrategy>> rnsProvider;
	private static Map<String, List<IStrategy>> rnsProviderHistory;

	public static List<IStrategy> build(AbstractDomainEntity entity, String operation) {
		if (rns == null) {
			initMap();
		}
		List<IStrategy> operationRules = new ArrayList<>();
		Map<String, List<IStrategy>> entityRules = rns.get(entity.getClass().getName());
		if (entityRules != null) {
			operationRules = entityRules.get(operation);
		}
		return operationRules;
	}

	private static void initMap() {
		// inicialização do mapa de regras de negócio total
		rns = new HashMap<>();

		// Inicialização do mapa de regras de negócio do produto
		rnsProduct = new HashMap<>();
		initProductRns();

		// Inicialização do mapa de regras de histórico de produto
		rnsProductHistory = new HashMap<>();
		initProductHistoryRns();

		// Inicializa��o do mapa de regras de neg�cio do cliente
		rnsCustomer = new HashMap<>();
		initCustomerRns();

		// Inicializa��o do mapa de regras de neg�cio do cliente
		rnsCustomerHistory = new HashMap<>();
		initCustomerHistoryRns();

		// Inicializa��o do mapa de regras de neg�cio do funcionario
		rnsEmployee = new HashMap<>();
		initEmployeeRns();

		// Inicializa��o do mapa de regras de neg�cio do funcionario
		rnsEmployeeHistory = new HashMap<>();
		initEmployeeHistoryRns();

		// Inicializa��o do mapa de regras de neg�cio do fornecedor
		rnsProvider = new HashMap<>();
		initProviderRns();

		// Inicializa��o do mapa de regras de neg�cio do fornecedor
		rnsProviderHistory = new HashMap<>();
		initProviderHistoryRns();

		// Adiciona regras de negócio no mapa
		rns.put(Product.class.getName(), rnsProduct);
		rns.put(ProductHistory.class.getName(), rnsProductHistory);
		rns.put(Customer.class.getName(), rnsCustomer);
		rns.put(CustomerHistory.class.getName(), rnsCustomerHistory);
		rns.put(Provider.class.getName(), rnsProvider);
		rns.put(ProviderHistory.class.getName(), rnsProviderHistory);
		rns.put(Employee.class.getName(), rnsEmployee);
		rns.put(EmployeeHistory.class.getName(), rnsEmployeeHistory);

	}

	private static void initProductRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		// Não há regras para a busca de produto
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new ProductFieldsValidator());
		rnsSave.add(new ProductAmountValidator());
		rnsSave.add(new ProductBaseValueValidator());
		rnsSave.add(new ProductSaleTypeComplementor());
		rnsSave.add(new InsertDateComplementor());
		rnsSave.add(new ProductActiveComplementor());
		rnsSave.add(new ProductCodeComplementor());

		rnsUpdate.add(new ProductFieldsValidator());
		rnsUpdate.add(new ProductAmountValidator());
		rnsUpdate.add(new ProductBaseValueValidator());
		rnsUpdate.add(new ProductSaleTypeComplementor());

		// Insere as regras de negócio por operação
		rnsProduct.put(EOperation.SAVE, rnsSave);
		rnsProduct.put(EOperation.UPDATE, rnsUpdate);
		rnsProduct.put(EOperation.DELETE, rnsDelete);
		rnsProduct.put(EOperation.FIND, rnsFind);
	}

	private static void initProductHistoryRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		// Não há regras para a busca de produto
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new ProductHistoryComplementor());

		// Insere as regras de negócio por operação
		rnsProductHistory.put(EOperation.SAVE, rnsSave);
		rnsProductHistory.put(EOperation.UPDATE, rnsUpdate);
		rnsProductHistory.put(EOperation.DELETE, rnsDelete);
		rnsProductHistory.put(EOperation.FIND, rnsFind);
	}

	private static void initCustomerRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new CustomerActiveComplementor());
		rnsSave.add(new CustomerCodeComplementor());
		rnsSave.add(new InsertDateComplementor());
		rnsSave.add(new CustomerFieldsValidator());
		rnsSave.add(new CustomerPhoneComplementor());

		rnsUpdate.add(new CustomerFieldsValidator());
		rnsUpdate.add(new CustomerPhoneComplementor());

		rnsFind.add(new CustomerSearchValidator());

		// Insere as regras de neg�cio por opera��o
		rnsCustomer.put(EOperation.SAVE, rnsSave);
		rnsCustomer.put(EOperation.UPDATE, rnsUpdate);
		rnsCustomer.put(EOperation.DELETE, rnsDelete);
		rnsCustomer.put(EOperation.FIND, rnsFind);
	}

	private static void initCustomerHistoryRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new CustomerHistoryComplementor());
		rnsUpdate.add(new CustomerHistoryComplementor());
		rnsDelete.add(new CustomerHistoryComplementor());
		
		// Insere as regras de negócio por operação
		rnsCustomerHistory.put(EOperation.SAVE, rnsSave);
		rnsCustomerHistory.put(EOperation.UPDATE, rnsUpdate);
		rnsCustomerHistory.put(EOperation.DELETE, rnsDelete);
		rnsCustomerHistory.put(EOperation.FIND, rnsFind);
	}
	
	private static void initEmployeeRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new EmployeeActiveComplementor());
		rnsSave.add(new EmployeeCodeComplementor());
		rnsSave.add(new InsertDateComplementor());
		rnsSave.add(new EmployeeSalaryValidator());
		rnsSave.add(new EmployeePhoneComplementor());
		rnsSave.add(new EmployeeFieldsValidator());
	
		rnsUpdate.add(new EmployeeSalaryValidator());
		rnsUpdate.add(new EmployeePhoneComplementor());
		rnsUpdate.add(new EmployeeFieldsValidator());
	
		rnsFind.add(new EmployeeSearchValidator());
		
		// Insere as regras de neg�cio por opera��o
		rnsEmployee.put(EOperation.SAVE, rnsSave);
		rnsEmployee.put(EOperation.UPDATE, rnsUpdate);
		rnsEmployee.put(EOperation.DELETE, rnsDelete);
		rnsEmployee.put(EOperation.FIND, rnsFind);
	}

	private static void initEmployeeHistoryRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new EmployeeHistoryComplementor());
		rnsUpdate.add(new EmployeeHistoryComplementor());
		rnsDelete.add(new EmployeeHistoryComplementor());

		// Insere as regras de negócio por operação
		rnsEmployeeHistory.put(EOperation.SAVE, rnsSave);
		rnsEmployeeHistory.put(EOperation.UPDATE, rnsUpdate);
		rnsEmployeeHistory.put(EOperation.DELETE, rnsDelete);
		rnsEmployeeHistory.put(EOperation.FIND, rnsFind);
	}
	
	private static void initProviderRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new ProviderActiveComplementor());
		rnsSave.add(new ProviderCodeComplementor());
		rnsSave.add(new InsertDateComplementor());
		rnsSave.add(new ProviderFieldsValidator());
		rnsSave.add(new ProviderPhoneComplementor());

		rnsUpdate.add(new ProviderFieldsValidator());
		rnsUpdate.add(new ProviderPhoneComplementor());

		rnsFind.add(new ProviderSearchValidator());
		
		// Insere as regras de neg�cio por opera��o
		rnsProvider.put(EOperation.SAVE, rnsSave);
		rnsProvider.put(EOperation.UPDATE, rnsUpdate);
		rnsProvider.put(EOperation.DELETE, rnsDelete);
		rnsProvider.put(EOperation.FIND, rnsFind);
	}

	private static void initProviderHistoryRns() {
		List<IStrategy> rnsSave = new ArrayList<>();
		List<IStrategy> rnsUpdate = new ArrayList<>();
		List<IStrategy> rnsFind = new ArrayList<>();
		List<IStrategy> rnsDelete = new ArrayList<>();

		rnsSave.add(new ProviderHistoryComplementor());
		rnsUpdate.add(new ProviderHistoryComplementor());
		rnsDelete.add(new ProviderHistoryComplementor());

		// Insere as regras de negócio por operação
		rnsProviderHistory.put(EOperation.SAVE, rnsSave);
		rnsProviderHistory.put(EOperation.UPDATE, rnsUpdate);
		rnsProviderHistory.put(EOperation.DELETE, rnsDelete);
		rnsProviderHistory.put(EOperation.FIND, rnsFind);
	}
}
