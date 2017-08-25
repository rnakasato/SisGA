package com.sisga.web.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

//TODO REFATORAR PARA SISGA
public class AccessListener implements PhaseListener {

	@Override
	public void afterPhase( PhaseEvent event ) {
		FacesContext context = event.getFacesContext();
		String currentPage = context.getViewRoot().getViewId();

		boolean isLoginPage = currentPage.contains( "login" );
		boolean isClientPage = currentPage.contains( "clientuser" );
		boolean isAdminPage = currentPage.contains( "admin" );

		// Object currentUser =
		// context.getExternalContext().getSessionMap().get( User.LOGGED_USER );
		//
		// boolean isAdminUser = currentUser instanceof Administrator;
		// boolean isOpUser = currentUser instanceof Operator;
		// boolean isClientUser = currentUser instanceof Customer;
		//
		// if( ! isClientUser || ( ! isLoginPage && ( currentUser == null ||
		// currentUser == "" ) ) ) {
		// // caso o usu疵io esteja logado como Administrador ou Operador ser�
		// // realizado o logout automatico
		// if( ! isClientUser && isClientPage && currentUser != null ) {
		// context.getExternalContext().getSessionMap().put( User.LOGGED_USER,
		// null );
		// }
		// if( isClientPage && currentPage.contains( "logged" ) ) {
		// Redirector.redirectTo( context.getExternalContext(),
		// "/clientuser/login.jsf?faces-redirect=true" );
		// }
		// }
		//
		// if( ( ! isAdminUser && ! isOpUser ) || ( ! isLoginPage && (
		// currentUser == null || currentUser == "" ) ) ) {
		// // caso o usu疵io esteja logado como Administrador ou Operador ser�
		// // realizado o logout automatico
		// if( ! isAdminUser && isAdminPage && currentUser != null ) {
		// context.getExternalContext().getSessionMap().put( User.LOGGED_USER,
		// null );
		// }
		// if( isAdminPage && ! isLoginPage ) {
		// Redirector.redirectTo( context.getExternalContext(),
		// "/admin/login.jsf?faces-redirect=true" );
		// }
		// }

	}

	@Override
	public void beforePhase( PhaseEvent event ) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
