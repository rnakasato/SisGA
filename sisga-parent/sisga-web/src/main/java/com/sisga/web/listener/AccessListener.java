package com.sisga.web.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.sisga.domain.user.User;
import com.sisga.domain.user.UserType;
import com.sisga.web.mb.LoginMB;

//TODO REFATORAR PARA SISGA
public class AccessListener implements PhaseListener {

	@Override
	public void afterPhase( PhaseEvent event ) {
		FacesContext context = event.getFacesContext();
		String currentPage = context.getViewRoot().getViewId();

		boolean isLoginPage = currentPage.contains( "login" );
		boolean isAdminPage = currentPage.contains( "gestao" ) || currentPage.contains( "relatorio" );
		boolean isLoggedPage = currentPage.contains( "logged" );

		User currentUser = ( User ) context.getExternalContext().getSessionMap().get( LoginMB.LOGGED_USER );

		if( ( ! isLoginPage || isLoggedPage ) && currentUser == null ) {
			// Redirector.redirectTo( context.getExternalContext(),
			// "/pages/login.jsf?faces-redirect=true" );
		} else if( ! isLoginPage ) {
			boolean isOpUser = currentUser.getUserType().getCode().equals( UserType.OPERADOR );

			if( isOpUser && isAdminPage ) {
				// REDIRECIONAR PARA PAGINA INFORMANDO QUE NAO POSSUI PERMISSAO
			}
		}

	}

	@Override
	public void beforePhase( PhaseEvent event ) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
