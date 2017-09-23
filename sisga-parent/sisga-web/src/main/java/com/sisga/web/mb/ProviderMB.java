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
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.ProviderHistory;
import com.sisga.domain.provider.ProviderOperation;
import com.sisga.domain.provider.filter.ProviderFilter;
import com.sisga.web.util.Redirector;

/**
 * @author Sergio Massao Umiji 20 de mar de 2017
 */
@ManagedBean( name = "providerMB" )
@ViewScoped
public class ProviderMB extends BaseMB {

	private static final long serialVersionUID = 1L;

	// utilizado para consulta de fornecedores
	private ProviderFilter filter;
	private List < Provider > providerList;

	// utilizado para cadastrar e alterar fornecedores
	private Provider provider;
	private String code;
	private String tel;
	private boolean doUpdate;
	private State selectedState;
	private City selectedCity;
	private List < City > cityList;
	private List < State > stateList;
	private String status;
	private String st;
	private boolean loadCity = false;
	private List < String > statusList;

	// Para manipulação de fornecedores
	private Provider selectedProvider;

	@PostConstruct
	public void init() {
		filter = new ProviderFilter();
		filter.setStatus( "TODOS" );
		provider = new Provider();
		newTelephonesCityState( provider );
		cityList = getCities();
		stateList = getStates();
		doUpdate = false;
		loadCity = false;

		statusList = new ArrayList();
		statusList.add( "ATIVO" );
		statusList.add( "INATIVO" );
		st = "ATIVO";

	}

	// Métodos Operacionais
	public void save() {
		prepareSaveProvider();
		ICommand commandSave;
		try {

			commandSave = FactoryCommand.build( provider, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null,
						new FacesMessage(
								Message.getMessage( "com.sisga.web.provider.info.saved", Message.INFO, provider )
										+ provider.getCode() ) );

				ProviderHistory history = new ProviderHistory();
				history.setProvider( provider );
				history.setOperationCode( ProviderOperation.CADASTRO_FORNECEDOR );
				commandSave = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandSave.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}

				Flash flash = ctx.getExternalContext().getFlash();
				flash.setKeepMessages( true );
				flash.setRedirect( true );
				Redirector.redirectTo( ctx.getExternalContext(),
						"/pages/gestao/fornecedores/consultarFornecedores.jsf?faces-redirect=true" );

			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update() {
		prepareUpdateProvider();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( provider, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.provider.info.updated", Message.INFO, provider ) ) );

				ProviderHistory history = new ProviderHistory();
				history.setProvider( provider );
				history.setOperationCode( ProviderOperation.ALTERACAO_FORNECEDOR );
				commandUpdate = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandUpdate.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}
				Flash flash = ctx.getExternalContext().getFlash();
				flash.setKeepMessages( true );
				flash.setRedirect( true );
				Redirector.redirectTo( ctx.getExternalContext(),
						"/pages/gestao/fornecedores/consultarFornecedores.jsf?faces-redirect=true" );
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete( Provider provider ) {
		ICommand commandUpdate;
		try {
			provider.setActive( false );
			commandUpdate = FactoryCommand.build( provider, EOperation.DELETE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.provider.info.updated", Message.INFO, provider ) ) );

				ProviderHistory history = new ProviderHistory();
				history.setProvider( provider );
				history.setOperationCode( ProviderOperation.EXCLUSAO_FORNECEDOR );
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
				"/pages/gestao/fornecedores/consultarFornecedores.jsf?faces-redirect=true" );

	}

	public void search() {
		try {
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			providerList = commandFind.execute().getEntityList();
			if( providerList != null && ! providerList.isEmpty() ) {
				for( int i = 0; i < providerList.size(); i ++ ) {
					providerList.get( i ).getTelephones().get( 0 )
							.setPnumber( providerList.get( i ).getTelephones().get( 0 ).getDdd()
									+ providerList.get( i ).getTelephones().get( 0 ).getPnumber() );
					providerList.get( i ).getTelephones().get( 1 )
							.setPnumber( providerList.get( i ).getTelephones().get( 1 ).getDdd()
									+ providerList.get( i ).getTelephones().get( 1 ).getPnumber() );
				}
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Métodos de view (para auxiliar carregamentos de dados na view)
	public void redirectToProviderUpdate( Provider provider ) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext context = ctx.getExternalContext();
		if( provider != null ) {

			context.getFlash().put( "provider", provider );
			StringBuilder sb = new StringBuilder();
			sb.append( "/pages/gestao/fornecedores/alterarFornecedores.jsf?faces-redirect=true" );
			sb.append( "&providerCode=" );
			sb.append( provider.getId() );

			String url = sb.toString();
			Redirector.redirectTo( context, url );

		} else {
			ctx.addMessage( null, new FacesMessage(
					Message.getMessage( "com.sisga.web.provider.info.select.provider", Message.INFO, provider ) ) );
		}
	}

	public void loadProvider() {
		try {
			if( loadCity == false ) {
				doUpdate = true;
				if( ! StringUtils.isEmpty( code ) ) {
					ProviderFilter filter = new ProviderFilter();
					filter.setId( Long.valueOf( code ) );
					filter.setStatus( "TODOS" );
					ICommand commandFind;
					commandFind = FactoryCommand.build( filter, EOperation.FIND );
					List < Provider > providerList = commandFind.execute().getEntityList();
					if( providerList != null && ! providerList.isEmpty() ) {
						provider = providerList.get( 0 );
						provider.getTelephones().get( 0 ).setPnumber( provider.getTelephones().get( 0 ).getDdd()
								+ provider.getTelephones().get( 0 ).getPnumber() );
						provider.getTelephones().get( 1 ).setPnumber( provider.getTelephones().get( 1 ).getDdd()
								+ provider.getTelephones().get( 1 ).getPnumber() );

						for( int i = 0; i < ( stateList.size() ); i ++ ) {
							if( providerList.get( 0 ).getAddress().getCity().getState().getUf()
									.equals( stateList.get( i ).getUf() ) ) {
								selectedState = stateList.get( i );

								City city = new City();
								city.setUf( selectedState.getUf() );
								List < City > cityList = new ArrayList < City >();
								try {
									commandFind = FactoryCommand.build( city, EOperation.FIND );
									cityList = commandFind.execute().getEntityList();
								} catch( ClassNotFoundException e ) {

									e.printStackTrace();
								}

								this.cityList = cityList;
								selectedCity = providerList.get( 0 ).getAddress().getCity();
								loadCity = true;

								if( providerList.get( 0 ).isActive() ) {
									st = "ATIVO";
								} else {
									st = "INATIVO";
								}
							}
						}
					}
				}
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

	private Provider newTelephonesCityState( Provider provider ) {
		provider.setTelephones( new ArrayList < Telephone >() );
		provider.setTelephones( new ArrayList < Telephone >() );
		provider.getTelephones().add( new Telephone() );
		provider.getTelephones().add( new Telephone() );
		provider.getTelephones().get( 0 ).setPhoneType( new PhoneType() );
		provider.getTelephones().get( 1 ).setPhoneType( new PhoneType() );

		provider.getTelephones().get( 0 ).getPhoneType().setCode( PhoneType.TELEFONE );
		provider.getTelephones().get( 0 ).getPhoneType().setId( 1L );

		provider.getTelephones().get( 1 ).getPhoneType().setCode( PhoneType.CELULAR );
		provider.getTelephones().get( 1 ).getPhoneType().setId( 2L );

		provider.setAddress( new Address() );
		provider.getAddress().setCity( new City() );

		this.provider = provider;
		return this.provider;
	}

	private List < City > getCities() {
		List < City > city = new ArrayList < City >();
		try {
			ICommand commandFind;
			commandFind = FactoryCommand.build( new City(), EOperation.FINDALL );
			city = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return city;
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
		selectedCity = cityList.get( 0 );

		loadCity = true;
	}

	public void viewDetails( Provider provider ) {
		selectedProvider = provider;
	}

	private Provider prepareSaveProvider() {
		tel = provider.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		provider.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		provider.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = provider.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		provider.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		provider.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		return provider;
	}

	private Provider prepareUpdateProvider() {
		tel = provider.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		provider.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		provider.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = provider.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		provider.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		provider.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		if( status.equals( "ATIVO" ) ) {
			provider.setActive( true );
		} else if( status.equals( "INATIVO" ) ) {
			provider.setActive( false );
		}

		return provider;
	}

	@Override
	public void clearFilter() {
		filter = new ProviderFilter();
		filter.setStatus( "TODOS" );
		;
	}

	// Getters e Setters

	public ProviderFilter getFilter() {
		return filter;
	}

	public void setFilter( ProviderFilter filter ) {
		this.filter = filter;
	}

	public List < Provider > getProviderList() {
		return providerList;
	}

	public void setProviderList( List < Provider > providerList ) {
		this.providerList = providerList;
	}

	public State getSelectedState() {
		return selectedState;
	}

	public void setSelectedState( State selectedState ) {
		this.selectedState = selectedState;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider( Provider provider ) {
		this.provider = provider;
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public boolean isDoUpdate() {
		return doUpdate;
	}

	public void setDoUpdate( boolean doUpdate ) {
		this.doUpdate = doUpdate;
	}

	public Provider getSelectedProvider() {
		return selectedProvider;
	}

	public void setSelectedProvider( Provider selectedProvider ) {
		this.selectedProvider = selectedProvider;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getStatus() {
		return status;
	}

	public void setStatus( String status ) {
		this.status = status;
	}

	public City getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity( City selectedCity ) {
		this.selectedCity = selectedCity;
	}

	public List < String > getStatusList() {
		return statusList;
	}

	public void setStatusList( List < String > statusList ) {
		this.statusList = statusList;
	}

}
