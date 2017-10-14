package com.sisga.web.mb;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.ICommand;
import com.sisga.core.core.util.Message;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.user.User;
import com.sisga.domain.user.filter.UserFilter;
import com.sisga.web.util.Redirector;

@ManagedBean( name = "sessionMB" )
@SessionScoped
public class LoginMB extends BaseMB {
	public static final String LOGGED_USER = "loggedUser";

	private User user;
	private String username;
	private String password;

	public void doLogin() {
		try {
			boolean hasError = false;
			hasError = validateFields();

			if( ! hasError ) {
				FacesContext context = FacesContext.getCurrentInstance();
				String currentPage = context.getViewRoot().getViewId();

				User user = ( User ) context.getExternalContext().getSessionMap().get( LoginMB.LOGGED_USER );

				if( user == null ) {
					hasError = executeLogin( context );
				}
			} else {
				addMessage( Message.getMessage( "com.sisga.core.business.validator.user.not.informed", Message.ERROR,
						this ) );
			}

		} catch( Exception e ) {
			e.printStackTrace();
		}
	}

	private boolean executeLogin( FacesContext context ) throws ClassNotFoundException {
		boolean hasError = false;
		boolean isOk = false;

		UserFilter filter = new UserFilter();

		filter.setActive( true );
		filter.setUsername( username );
		filter.setPassword( password );
		filter.setIsLogin( true );

		ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );

		User user = ( User ) commandFind.execute().getFirstResult();
		// if the password and the username matches the user will be returned

		if( user == null ) {
			hasError = true;
		} else {
			isOk = true;
		}

		if( isOk ) {
			context.getExternalContext().getSessionMap().put( LoginMB.LOGGED_USER, user );
			if( user.getIsFirstLogin() != null && user.getIsFirstLogin() ) {
				Redirector.redirectTo( context.getExternalContext(), "/logged/firstLogin.jsf?faces-redirect=true" );
			} else {
				Redirector.redirectTo( context.getExternalContext(), "/logged/paginaInicial.jsf?faces-redirect=true" );
			}

			addRedirectMessage( "Bem vindo " + user.getUsername() );
		}

		return hasError;
	}

	private boolean validateFields() {
		boolean isValid = true;
		if( StringUtils.isNotEmpty( username ) || StringUtils.isNotEmpty( password ) ) {
			isValid = false;
		}
		return isValid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	@Override
	public void clearFilter() {
		// TODO Auto-generated method stub

	}

}
