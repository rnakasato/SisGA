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
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.core.util.Message;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.address.Address;
import com.sisga.domain.address.City;
import com.sisga.domain.address.State;
import com.sisga.domain.communication.PhoneType;
import com.sisga.domain.communication.Telephone;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.filter.CustomerFilter;
import com.sisga.domain.user.User;
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
	private String status;
	private String code;
	private String telefone;
	private String celular;
	private boolean doUpdate;
	private State selectedState;
	private List < City > cityList;
	private List < State > stateList;
	private List < User > userList;

	// Para manipulação de clientes
	private Customer selectedCustomer;

	@PostConstruct
	public void init() {

		filter = new CustomerFilter();
		filter.setStatus( "TODOS" );
		customer = new Customer();
		doUpdate = false;
		newTelephonesCityState( customer );
		cityList = getCities();
		stateList = getStates();
		userList = getUsers();

	}

	// Métodos Operacionais
	public void save() {
		prepareSaveCustomer();
		ICommand commandSave;
		try {

			commandSave = FactoryCommand.build( customer, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null,
						new FacesMessage(
								Message.getMessage( "com.sisga.web.customer.info.saved", Message.INFO, customer )
										+ customer.getCode() ) );

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
		prepareUpdateCustomer();

		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( customer, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.customer.info.updated", Message.INFO, customer ) ) );

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
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.customer.info.deleted", Message.INFO, customer ) ) );

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
			filter.setStatus( status );
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			customerList = commandFind.execute().getEntityList();
			if( customerList != null && ! customerList.isEmpty() ) {
				for( int i = 0; i < customerList.size(); i ++ ) {
					customerList.get( i ).getTelephones().get( 0 )
							.setPnumber( customerList.get( i ).getTelephones().get( 0 ).getDdd()
									+ customerList.get( i ).getTelephones().get( 0 ).getPnumber() );
					customerList.get( i ).getTelephones().get( 1 )
							.setPnumber( customerList.get( i ).getTelephones().get( 1 ).getDdd()
									+ customerList.get( i ).getTelephones().get( 1 ).getPnumber() );
				}
			}

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
			ctx.addMessage( null, new FacesMessage(
					Message.getMessage( "com.sisga.web.customer.info.select.client", Message.INFO, customer ) ) );
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
					customer.getTelephones().get( 0 ).setPnumber( customer.getTelephones().get( 0 ).getDdd()
							+ customer.getTelephones().get( 0 ).getPnumber() );
					customer.getTelephones().get( 0 ).setPnumber( customer.getTelephones().get( 1 ).getDdd()
							+ customer.getTelephones().get( 1 ).getPnumber() );
				}
			}

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

	private void newTelephonesCityState( Customer customer ) {
		customer.setTelephones( new ArrayList < Telephone >() );
		customer.setTelephones( new ArrayList < Telephone >() );
		customer.getTelephones().add( new Telephone() );
		customer.getTelephones().add( new Telephone() );
		customer.getTelephones().get( 0 ).setPhoneType( new PhoneType() );
		customer.getTelephones().get( 1 ).setPhoneType( new PhoneType() );
		customer.getTelephones().get( 0 ).getPhoneType().setCode( PhoneType.TELEFONE );
		customer.getTelephones().get( 1 ).getPhoneType().setCode( PhoneType.CELULAR );
		customer.getTelephones().get( 0 ).getPhoneType().setId( 1L );
		customer.getTelephones().get( 1 ).getPhoneType().setId( 2L );
		customer.setAddress( new Address() );
		customer.getAddress().setCity( new City() );
		customer.getAddress().getCity().setState( new State() );
		this.customer = customer;
	}

	private List < City > getCities() {
		List < City > cityList = new ArrayList < City >();
		try {
			ICommand commandFind;
			commandFind = FactoryCommand.build( new City(), EOperation.FINDALL );
			cityList = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return cityList;
	}

	private List < State > getStates() {
		List < State > states = new ArrayList < State >();
		try {
			ICommand commandFind;
			commandFind = FactoryCommand.build( new State(), EOperation.FINDALL );
			states = commandFind.execute().getEntityList();

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return states;
	}

	private List < User > getUsers() {
		List < User > users = new ArrayList < User >();
		// try {
		// ICommand commandFind;
		// commandFind = FactoryCommand.build(new User(), EOperation.FINDALL);
		// users = commandFind.execute().getEntityList();

		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }

		User u = new User();
		u.setFirstName( "Sergio" );
		users.add( u );
		u.setFirstName( "Massao" );
		users.add( u );

		return users;
	}

	public void loadCities( AjaxBehaviorEvent event ) {
		City city = new City();
		city.setUf( selectedState.getUf() );
		List < City > cityList = new ArrayList < City >();
		try {
			ICommand commandFind;
			commandFind = FactoryCommand.build( city, EOperation.FIND );
			cityList = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		this.cityList = cityList;
	}

	public void viewDetails( Customer customer ) {
		selectedCustomer = customer;
	}

	private Customer prepareSaveCustomer() {
		String tel = customer.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		customer.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		customer.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = customer.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		customer.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		customer.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		return customer;
	}

	private Customer prepareUpdateCustomer() {
		String tel = customer.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		customer.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		customer.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = customer.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		customer.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		customer.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		if( status.equals( "ATIVO" ) ) {
			customer.setActive( true );
		} else if( status.equals( "INATIVO" ) ) {
			customer.setActive( false );
		}

		return customer;
	}

	@Override
	public void clearFilter() {
		filter = new CustomerFilter();
		filter.setStatus( "TODOS" );
	}

	// Getters e Setters
	public CustomerFilter getFilter() {
		return filter;
	}

	public void setFilter( CustomerFilter filter ) {
		this.filter = filter;
	}

	public List < Customer > getCustomerList() {
		return customerList;
	}

	public void setCustomerList( List < Customer > customerList ) {
		this.customerList = customerList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer( Customer customer ) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus( String status ) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public State getSelectedState() {
		return selectedState;
	}

	public void setSelectedState( State selectedState ) {
		this.selectedState = selectedState;
	}

	public List < City > getCityList() {
		return cityList;
	}

	public void setCityList( List < City > cityList ) {
		this.cityList = cityList;
	}

	public List < State > getStateList() {
		return stateList;
	}

	public void setStateList( List < State > stateList ) {
		this.stateList = stateList;
	}

	public boolean isDoUpdate() {
		return doUpdate;
	}

	public void setDoUpdate( boolean doUpdate ) {
		this.doUpdate = doUpdate;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone( String telefone ) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular( String celular ) {
		this.celular = celular;
	}

	public void setSelectedCustomer( Customer selectedCustomer ) {
		this.selectedCustomer = selectedCustomer;
	}

	public List < User > getUserList() {
		return userList;
	}

	public void setUserList( List < User > userList ) {
		this.userList = userList;
	}

}
