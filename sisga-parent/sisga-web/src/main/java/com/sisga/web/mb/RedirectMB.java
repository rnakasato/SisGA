package com.sisga.web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.sisga.web.util.Redirector;

@ManagedBean( name = "redirectMB" )
@ViewScoped
public class RedirectMB {

	public void redirect( String page ) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String redirect = "?faces-redirect=true";
		Redirector.redirectTo( context, page + redirect );
	}

}
