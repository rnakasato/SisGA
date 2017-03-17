package com.sisga.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sisga.core.ICommand;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.filter.CustomerFilter;
import com.sisga.domain.user.User;

/**
 * 
 * @author Sergio Massao Umiji 
 * 14 de mar de 2017
 */

@SessionScoped
@ManagedBean(name="listarClientesMB")

public class ListarClientesMB {

	private List<Customer> customers = null;
	private Customer customer;
	private CustomerFilter customerFilter;
	private List<User> users;
	private List<User> userSellers;
	
	@PostConstruct
	private void init(){
		customerFilter = new CustomerFilter();
		customerFilter.setName("");
		customers = new ArrayList<Customer>();
		userSellers = new ArrayList<User>();
		
		try {
			ICommand commandFindAll = FactoryCommand.build( new Customer(), EOperation.FINDALL );
			customers = commandFindAll.execute().getEntityList();
			commandFindAll = FactoryCommand.build( new User(), EOperation.FINDALL );
			users = commandFindAll.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		if(users!= null){
			for(int i=users.size();i<users.size();i++ ){
				if(users.get(i).getDescription() == "SELLER"){
					userSellers.add(users.get(i));
				}
			}
		}
	}
	
	public void find() {
		customer = new Customer();
		customer.setName(customerFilter.getName());
		if(customerFilter.getStatus().equals("ATIVO")){
			customer.setActive(true);
		}else if(customerFilter.getStatus().equals("INATIVO")){
			customer.setActive(false);
		}
		try {
			ICommand commandFind = FactoryCommand.build( customer, EOperation.FIND );
			customers = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public void add() {
		customer = new Customer();
		
	}

	public void save() {
		try {
			ICommand commandAdd = FactoryCommand.build( customer, EOperation.SAVE );
			try {
				ICommand commandFindAll = FactoryCommand.build( new Customer(), EOperation.FINDALL );
				customers = commandFindAll.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			ICommand commandAlt = FactoryCommand.build( customer, EOperation.UPDATE );
			try {
				ICommand commandFindAll = FactoryCommand.build( new Customer(), EOperation.FINDALL );
				customers = commandFindAll.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void alter(Customer customer) {
		this.customer = customer;
	}

	public void del(Customer customer) {
		try {
			ICommand commandDel = FactoryCommand.build( customer, EOperation.DELETE );
			try {
				ICommand commandFindAll = FactoryCommand.build( new Customer(), EOperation.FINDALL );
				customers = commandFindAll.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public void details(Customer customer) {
		this.customer = customer;
	}
	
	public void cleanFilters() {
		customerFilter = new CustomerFilter();
		customerFilter.setName("");
		customers = new ArrayList<Customer>();
		userSellers = new ArrayList<User>();
		
		try {
			ICommand commandFindAll = FactoryCommand.build( new Customer(), EOperation.FINDALL );
			customers = commandFindAll.execute().getEntityList();
			commandFindAll = FactoryCommand.build( new User(), EOperation.FINDALL );
			users = commandFindAll.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		if(users!= null){
			for(int i=users.size();i<users.size();i++ ){
				if(users.get(i).getDescription() == "SELLER"){
					userSellers.add(users.get(i));
				}
			}
		}
	}
	
	//getters and setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerFilter getCustomerFilter() {
		return customerFilter;
	}

	public void setCustomerFilter(CustomerFilter customerFilter) {
		this.customerFilter = customerFilter;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public List<User> getUserSellers() {
		return userSellers;
	}

}
