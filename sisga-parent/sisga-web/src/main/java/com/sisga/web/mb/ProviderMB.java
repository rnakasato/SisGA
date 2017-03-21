package com.sisga.web.mb;

import java.io.IOException;
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
import org.primefaces.event.FileUploadEvent;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.core.util.ImageUtils;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.communication.PhoneType;
import com.sisga.domain.communication.Telephone;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductionType;
import com.sisga.domain.product.SaleType;
import com.sisga.domain.product.StockType;
import com.sisga.domain.product.filter.ProductFilter;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.ProviderHistory;
import com.sisga.domain.provider.ProviderOperation;
import com.sisga.domain.provider.filter.ProviderFilter;
import com.sisga.web.util.Redirector;

/**
 * @author Sergio Massao Umiji
 *         20 de mar de 2017
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
	private String telephone;
	private String celular;
	private String status;
	private String code;
	private boolean doUpdate;
	
	// Para manipulação de fornecedores
	private Provider selectedProvider;

	@PostConstruct
	public void init() {
		
		filter = new ProviderFilter();
		provider = new Provider();
		provider.setTelephones(new ArrayList<Telephone>());
		doUpdate = false;
	}

	// Métodos Operacionais
	public void save() {
		prepareProvider();
		ICommand commandSave;
		try {

			commandSave = FactoryCommand.build( provider, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Fornecedor cadastrado com código: " + provider.getCode() ) );

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
		prepareProvider();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( provider, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Fornecedor Alterado" ) );

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
			commandUpdate = FactoryCommand.build( provider, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Fornecedor deletado" ) );

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
			filter.setStatus(status);
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			providerList = commandFind.execute().getEntityList();

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
			sb.append( provider.getCode() );

			String url = sb.toString();
			Redirector.redirectTo( context, url );

		} else {
			ctx.addMessage( null, new FacesMessage( "Selecione um fornecedor para alterar" ) );
		}
	}

	public void loadProvider() {
		try {
			doUpdate = true;
			if( ! StringUtils.isEmpty( code ) ) {
				ProviderFilter filter = new ProviderFilter();
				filter.setCode( code );
				ICommand commandFind;
				commandFind = FactoryCommand.build( filter, EOperation.FIND );
				List < Provider > providerList = commandFind.execute().getEntityList();
				if( providerList != null && ! providerList.isEmpty() ) {
					provider = providerList.get( 0 );
				}
			}

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

	public void viewDetails( Provider provider ) {
		selectedProvider = provider;
	}

	private Provider prepareProvider() {
		Telephone tel = new Telephone();
		Telephone cel = new Telephone();
		
		PhoneType type = new PhoneType();
		
		tel.setPnumber(telephone);
		type.setDescription(PhoneType.TELEFONE);
		tel.setPhoneType(type);
		provider.setTelephones(new ArrayList<Telephone>());
		provider.getTelephones().add(tel);
		
		cel.setPnumber(celular);
		type.setDescription(PhoneType.CELULAR);
		cel.setPhoneType(type);
		provider.getTelephones().add(cel);
		
		return provider;
	}

	@Override
	public void clearFilter() {
		filter = new ProviderFilter();
	}

	// Getters e Setters

	public ProviderFilter getFilter() {
		return filter;
	}

	public void setFilter(ProviderFilter filter) {
		this.filter = filter;
	}

	public List<Provider> getProviderList() {
		return providerList;
	}

	public void setProviderList(List<Provider> providerList) {
		this.providerList = providerList;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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

	public Provider getSelectedProvider() {
		return selectedProvider;
	}

	public void setSelectedProvider(Provider selectedProvider) {
		this.selectedProvider = selectedProvider;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
