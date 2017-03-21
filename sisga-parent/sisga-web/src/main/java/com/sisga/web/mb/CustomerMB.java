package com.sisga.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.communication.PhoneType;
import com.sisga.domain.communication.Telephone;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.filter.CustomerFilter;
import com.sisga.web.util.Redirector;

/**
 * @author Sergio Massao Umiji
 *         20 de mar de 2017
 */
@ManagedBean( name = "customerMB" )
@ViewScoped
public class CustomerMB extends BaseMB {

	private static final long serialVersionUID = 1L;

	// utilizado para consulta de clientes
	private CustomerFilter filter;
	private List < Customer > customerList;

	// utilizado para cadastrar e alterar clientes
	private Customer customer;
	private String telephone;
	private String celular;
	private String status;
	private String code;
	private boolean doUpdate;
	
	// Para manipulação de clientes
	private Customer selectedCustomer;

	@PostConstruct
	public void init() {
		
		filter = new CustomerFilter();
		customer = new Customer();
		customer.setTelephones(new ArrayList<Telephone>());
		doUpdate = false;
	}

	// Métodos Operacionais
	public void save() {
		prepareCustomer();
		ICommand commandSave;
		try {

			commandSave = FactoryCommand.build( customer, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Cliente cadastrado com código: " + customer.getCode() ) );

				CustomerHistory history = new CustomerHistory();
				history.setCustomer( customer );
				history.setOperationCode( CustomerOperation.CADASTRO_CLIENTE );
				commandSave = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandSave.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}

				Flash flash = ctx.getExternalContext().getFlash();
				flash.setKeepMessages( true );
				flash.setRedirect( true );
				Redirector.redirectTo( ctx.getExternalContext(),
						"/pages/gestao/clientes/consultarClientes.jsf?faces-redirect=true" );

			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update() {
		prepareCustomer();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( customer, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Cliente Alterado" ) );

				CustomerHistory history = new CustomerHistory();
				history.setCustomer( customer );
				history.setOperationCode( CustomerOperation.ALTERACAO_CLIENTE );
				commandUpdate = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandUpdate.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}
				Flash flash = ctx.getExternalContext().getFlash();
				flash.setKeepMessages( true );
				flash.setRedirect( true );
				Redirector.redirectTo( ctx.getExternalContext(),
						"/pages/gestao/clientes/consultarClientes.jsf?faces-redirect=true" );
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete( Customer customer ) {
		ICommand commandUpdate;
		try {
			customer.setActive( false );
			commandUpdate = FactoryCommand.build( customer, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Cliente deletado" ) );

				CustomerHistory history = new CustomerHistory();
				history.setCustomer( customer );
				history.setOperationCode( CustomerOperation.EXCLUSAO_CLIENTE );
				commandUpdate = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandUpdate.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}
				search();
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancel() {
		Redirector.redirectTo( FacesContext.getCurrentInstance().getExternalContext(),
				"/pages/gestao/clientes/consultarClientes.jsf?faces-redirect=true" );

	}

	public void search() {
		try {
			filter.setStatus(status);
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			customerList = commandFind.execute().getEntityList();

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Métodos de view (para auxiliar carregamentos de dados na view)
	public void redirectToCustomerUpdate( Customer customer ) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext context = ctx.getExternalContext();
		if( customer != null ) {

			context.getFlash().put( "customer", customer );
			StringBuilder sb = new StringBuilder();
			sb.append( "/pages/gestao/clientes/alterarClientes.jsf?faces-redirect=true" );
			sb.append( "&customerCode=" );
			sb.append( customer.getCode() );

			String url = sb.toString();
			Redirector.redirectTo( context, url );

		} else {
			ctx.addMessage( null, new FacesMessage( "Selecione um cliente para alterar" ) );
		}
	}

	public void loadCustomer() {
		try {
			doUpdate = true;
			if( ! StringUtils.isEmpty( code ) ) {
				CustomerFilter filter = new CustomerFilter();
				filter.setCode( code );
				ICommand commandFind;
				commandFind = FactoryCommand.build( filter, EOperation.FIND );
				List < Customer > customerList = commandFind.execute().getEntityList();
				if( customerList != null && ! customerList.isEmpty() ) {
					customer = customerList.get( 0 );
				}
			}

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

	public void viewDetails( Customer customer ) {
		selectedCustomer = customer;
	}

	private Customer prepareCustomer() {
		Telephone tel = new Telephone();
		Telephone cel = new Telephone();
		
		PhoneType type = new PhoneType();
		
		tel.setPnumber(telephone);
		type.setDescription(PhoneType.TELEFONE);
		tel.setPhoneType(type);
		customer.setTelephones(new ArrayList<Telephone>());
		customer.getTelephones().add(tel);
		
		cel.setPnumber(celular);
		type.setDescription(PhoneType.CELULAR);
		cel.setPhoneType(type);
		customer.getTelephones().add(cel);
		
		return customer;
	}

	@Override
	public void clearFilter() {
		filter = new CustomerFilter();
	}

	// Getters e Setters
	public CustomerFilter getFilter() {
		return filter;
	}

	public void setFilter(CustomerFilter filter) {
		this.filter = filter;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isDoUpdate() {
		return doUpdate;
	}

	public void setDoUpdate(boolean doUpdate) {
		this.doUpdate = doUpdate;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	
}
