package com.sisga.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.component.dialog.Dialog;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.sisga.core.ICommand;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.AbstractDomainEntity;

public abstract class BaseMB < T extends AbstractDomainEntity > implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean isSelected;
	private Dialog saveDialog;
	private Dialog updateDialog;

	private List < T > filteredValue;

	public void select( SelectEvent event ) {
		isSelected = true;
	}

	public void unSelect( UnselectEvent event ) {
		isSelected = false;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public abstract void clearFilter();

	public void addMessage( String msg ) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( msg ) );
	}

	public void addRedirectMessage( String msg ) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ext = context.getExternalContext();
		ext.getFlash().setKeepMessages( true );
		ext.getFlash().setRedirect( true );
		context.addMessage( null, new FacesMessage( msg ) );
	}

	public Date getToday() {
		Calendar today = Calendar.getInstance();
		today.set( Calendar.HOUR, 0 );
		today.set( Calendar.MINUTE, 0 );
		today.set( Calendar.SECOND, 0 );
		today.set( Calendar.MILLISECOND, 0 );
		return today.getTime();
	}
	
	public <E extends AbstractDomainEntity> List<E> getSelectEntity(E entity){
			List < E > entityList = new ArrayList < E >();
			try {
				ICommand commandFind;
				commandFind = FactoryCommand.build( entity, EOperation.FINDALL );
				entityList = commandFind.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
			return entityList;
	}

	public Dialog getSaveDialog() {
		return saveDialog;
	}

	public void setSaveDialog( Dialog saveDialog ) {
		this.saveDialog = saveDialog;
	}

	public Dialog getUpdateDialog() {
		return updateDialog;
	}

	public void setUpdateDialog( Dialog updateDialog ) {
		this.updateDialog = updateDialog;
	}

	public List < T > getFilteredValue() {
		if( filteredValue == null ) {
			filteredValue = new ArrayList <>();
		}
		return filteredValue;
	}

	public void setFilteredValue( List < T > filteredValue ) {
		this.filteredValue = filteredValue;
	}

}
