package com.sisga.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

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
import com.sisga.domain.user.User;
import com.sisga.domain.user.UserHistory;
import com.sisga.domain.user.UserOperation;
import com.sisga.domain.user.UserType;
import com.sisga.domain.user.filter.UserFilter;

@ManagedBean( name = "userMB" )
@ViewScoped
public class UserMB extends BaseMB < User > {

	private static final long serialVersionUID = 1L;

	private UserFilter filter;
	private List < User > userList;

	// utilizado para cadastrar e alterar usuários
	private User user;
	private String code;
	private boolean doUpdate;
	private State selectedState;
	private List < City > cityList;
	private List < State > stateList;
	private List < UserType > userTypeList;
	private String status;

	// Para manipulação de usuários
	private User selectedUser;

	@PostConstruct
	public void init() {

		filter = new UserFilter();
		user = new User();
		doUpdate = false;
		newTelephonesCityState( user );
		cityList = getSelectEntity( new City() );
		stateList = getSelectEntity( new State() );
		userTypeList = getSelectEntity( new UserType() );
	}

	// Métodos Operacionais
	public void save() {
		prepareSaveUser();
		try {
			ICommand commandSave;
			commandSave = FactoryCommand.build( user, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Usuário cadastrado com código: " + user.getCode() ) );

				ICommand commandSaveH;
				UserHistory history = new UserHistory();
				history.setUser( user );
				history.setOperationCode( UserOperation.CADASTRO_USUARIO );
				commandSaveH = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandSaveH.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}

				if( getSaveDialog() != null ) {
					RequestContext.getCurrentInstance()
							.execute( "PF('" + getSaveDialog().getWidgetVar() + "').hide();" );
				}

				search();
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update() {
		prepareUpdateUser();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( user, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.user.info.updated", Message.INFO, user ) ) );

				UserHistory history = new UserHistory();
				history.setUser( user );
				history.setOperationCode( UserOperation.ALTERACAO_USUARIO );
				commandUpdate = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandUpdate.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}

				if( getUpdateDialog() != null ) {
					RequestContext.getCurrentInstance()
							.execute( "PF('" + getUpdateDialog().getWidgetVar() + "').hide();" );
				}

				search();

			}

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

	public void delete( User User ) {
		ICommand commandUpdate;
		try {
			User.setActive( false );
			commandUpdate = FactoryCommand.build( User, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.User.info.deleted", Message.INFO, User ) ) );

				UserHistory history = new UserHistory();
				history.setUser( User );
				history.setOperationCode( UserOperation.EXCLUSAO_USUARIO );
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

	public void setUpdate( User user ) {
		doUpdate = true;
		this.user = user;
	}

	public void setSave() {
		doUpdate = false;
		this.user = new User();
		newTelephonesCityState( user );
	}

	public void search() {
		try {
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			userList = commandFind.execute().getEntityList();
			if( userList != null && ! userList.isEmpty() ) {
				for( int i = 0; i < userList.size(); i ++ ) {
					userList.get( i ).getTelephones().get( 0 )
							.setPnumber( userList.get( i ).getTelephones().get( 0 ).getDdd()
									+ userList.get( i ).getTelephones().get( 0 ).getPnumber() );
					userList.get( i ).getTelephones().get( 1 )
							.setPnumber( userList.get( i ).getTelephones().get( 1 ).getDdd()
									+ userList.get( i ).getTelephones().get( 1 ).getPnumber() );
				}
			}
			setFilteredValue( userList );

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	private void newTelephonesCityState( User user ) {
		user.setTelephones( new ArrayList < Telephone >() );
		user.setTelephones( new ArrayList < Telephone >() );
		user.getTelephones().add( new Telephone() );
		user.getTelephones().add( new Telephone() );
		user.getTelephones().get( 0 ).setPhoneType( new PhoneType() );
		user.getTelephones().get( 1 ).setPhoneType( new PhoneType() );
		user.getTelephones().get( 0 ).getPhoneType().setCode( PhoneType.TELEFONE );
		user.getTelephones().get( 1 ).getPhoneType().setCode( PhoneType.CELULAR );
		user.getTelephones().get( 0 ).getPhoneType().setId( 1L );
		user.getTelephones().get( 1 ).getPhoneType().setId( 2L );
		user.setAddress( new Address() );
		user.getAddress().setCity( new City() );
		this.user = user;
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

	public void viewDetails( User user ) {
		selectedUser = user;
	}

	private User prepareUpdateUser() {
		String tel = user.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		user.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		user.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = user.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		user.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		user.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		if( status.equals( "ATIVO" ) ) {
			user.setActive( true );
		} else if( status.equals( "INATIVO" ) ) {
			user.setActive( false );
		}

		return user;
	}

	private User prepareSaveUser() {
		String tel = user.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		user.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		user.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = user.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		user.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		user.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		return user;
	}

	@Override
	public void clearFilter() {
		filter = new UserFilter();
	}

	
	// Getters e Setters
	/**
	 * @return the filter
	 */
	public UserFilter getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            the filter to set
	 */
	public void setFilter( UserFilter filter ) {
		this.filter = filter;
	}

	/**
	 * @return the UserList
	 */
	public List < User > getUserList() {
		return userList;
	}

	/**
	 * @param UserList
	 *            the UserList to set
	 */
	public void setUserList( List < User > UserList ) {
		this.userList = UserList;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser( User user ) {
		this.user = user;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode( String code ) {
		this.code = code;
	}

	/**
	 * @return the doUpdate
	 */
	public boolean isDoUpdate() {
		return doUpdate;
	}

	/**
	 * @param doUpdate
	 *            the doUpdate to set
	 */
	public void setDoUpdate( boolean doUpdate ) {
		this.doUpdate = doUpdate;
	}

	/**
	 * @return the selectedState
	 */
	public State getSelectedState() {
		return selectedState;
	}

	/**
	 * @param selectedState
	 *            the selectedState to set
	 */
	public void setSelectedState( State selectedState ) {
		this.selectedState = selectedState;
	}

	/**
	 * @return the cityList
	 */
	public List < City > getCityList() {
		return cityList;
	}

	/**
	 * @param cityList
	 *            the cityList to set
	 */
	public void setCityList( List < City > cityList ) {
		this.cityList = cityList;
	}

	/**
	 * @return the stateList
	 */
	public List < State > getStateList() {
		return stateList;
	}

	/**
	 * @param stateList
	 *            the stateList to set
	 */
	public void setStateList( List < State > stateList ) {
		this.stateList = stateList;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus( String status ) {
		this.status = status;
	}

	/**
	 * @return the selectedUser
	 */
	public User getSelectedUser() {
		return selectedUser;
	}

	/**
	 * @param selectedUser
	 *            the selectedUser to set
	 */
	public void setSelectedUser( User selectedUser ) {
		this.selectedUser = selectedUser;
	}

	/**
	 * @return the userTypeList
	 */
	public List < UserType > getUserTypeList() {
		return userTypeList;
	}

	/**
	 * @param userTypeList
	 *            the userTypeList to set
	 */
	public void setUserTypeList( List < UserType > userTypeList ) {
		this.userTypeList = userTypeList;
	}
	
	

	

}
