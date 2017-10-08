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
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.EmployeeHistory;
import com.sisga.domain.employee.EmployeeOperation;
import com.sisga.domain.employee.filter.EmployeeFilter;
import com.sisga.domain.product.Product;
import com.sisga.web.util.Redirector;

/**
 * @author Sergio Massao Umiji 20 de mar de 2017
 */
@ManagedBean( name = "employeeMB" )
@ViewScoped
public class EmployeeMB extends BaseMB<Employee> {

	private static final long serialVersionUID = 1L;

	// utilizado para consulta de funcionarios
	private EmployeeFilter filter;
	private List < Employee > employeeList;

	// utilizado para cadastrar e alterar funcionarios
	private Employee employee;
	private String code;
	private boolean doUpdate;
	private State selectedState;
	private List < City > cityList;
	private List < State > stateList;
	private String status;

	// Para manipulação de funcionarios
	private Employee selectedEmployee;

	@PostConstruct
	public void init() {

		filter = new EmployeeFilter();
		filter.setStatus( "TODOS" );
		employee = new Employee();
		doUpdate = false;
		newTelephonesCityState( employee );
		cityList = getCities();
		stateList = getStates();
	}

	// Métodos Operacionais
	public void save() {
		prepareSaveEmployee();
		try {
			ICommand commandSave;
			commandSave = FactoryCommand.build( employee, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Funcionário cadastrado com código: " + employee.getCode() ) );

				ICommand commandSaveH;
				EmployeeHistory history = new EmployeeHistory();
				history.setEmployee( employee );
				history.setOperationCode( EmployeeOperation.CADASTRO_FUNCIONARIO );
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
		prepareUpdateEmployee();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( employee, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.employee.info.updated", Message.INFO, employee ) ) );

				EmployeeHistory history = new EmployeeHistory();
				history.setEmployee( employee );
				history.setOperationCode( EmployeeOperation.ALTERACAO_FUNCIONARIO );
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

	public void delete( Employee employee ) {
		ICommand commandUpdate;
		try {
			employee.setActive( false );
			commandUpdate = FactoryCommand.build( employee, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage(
						Message.getMessage( "com.sisga.web.employee.info.deleted", Message.INFO, employee ) ) );

				EmployeeHistory history = new EmployeeHistory();
				history.setEmployee( employee );
				history.setOperationCode( EmployeeOperation.EXCLUSAO_FUNCIONARIO );
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

	public void setUpdate( Employee employee ) {
		doUpdate = true;
		this.employee = employee;
	}
	
	public void setSave() {
		doUpdate = false;
		this.employee= new Employee();
		newTelephonesCityState( employee );
	}
	
	public void search() {
		try {
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			employeeList = commandFind.execute().getEntityList();
			if( employeeList != null && ! employeeList.isEmpty() ) {
				for( int i = 0; i < employeeList.size(); i ++ ) {
					employeeList.get( i ).getTelephones().get( 0 )
							.setPnumber( employeeList.get( i ).getTelephones().get( 0 ).getDdd()
									+ employeeList.get( i ).getTelephones().get( 0 ).getPnumber() );
					employeeList.get( i ).getTelephones().get( 1 )
							.setPnumber( employeeList.get( i ).getTelephones().get( 1 ).getDdd()
									+ employeeList.get( i ).getTelephones().get( 1 ).getPnumber() );
				}
			}
			setFilteredValue( employeeList );

		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	

	private void newTelephonesCityState( Employee employee ) {
		employee.setTelephones( new ArrayList < Telephone >() );
		employee.setTelephones( new ArrayList < Telephone >() );
		employee.getTelephones().add( new Telephone() );
		employee.getTelephones().add( new Telephone() );
		employee.getTelephones().get( 0 ).setPhoneType( new PhoneType() );
		employee.getTelephones().get( 1 ).setPhoneType( new PhoneType() );
		employee.getTelephones().get( 0 ).getPhoneType().setCode( PhoneType.TELEFONE );
		employee.getTelephones().get( 1 ).getPhoneType().setCode( PhoneType.CELULAR );
		employee.getTelephones().get( 0 ).getPhoneType().setId( 1L );
		employee.getTelephones().get( 1 ).getPhoneType().setId( 2L );
		employee.setAddress( new Address() );
		employee.getAddress().setCity( new City() );
		this.employee = employee;
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
	}

	public void viewDetails( Employee employee ) {
		selectedEmployee = employee;
	}

	private Employee prepareUpdateEmployee() {
		String tel = employee.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		employee.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		employee.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = employee.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		employee.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		employee.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		if( status.equals( "ATIVO" ) ) {
			employee.setActive( true );
		} else if( status.equals( "INATIVO" ) ) {
			employee.setActive( false );
		}

		return employee;
	}

	private Employee prepareSaveEmployee() {
		String tel = employee.getTelephones().get( 0 ).getPnumber();
		String[] dddtel = tel.split( " " );
		employee.getTelephones().get( 0 ).setDdd( dddtel[0].substring( 1, 3 ) );
		employee.getTelephones().get( 0 ).setPnumber( dddtel[1].replace( "-", "" ) );

		tel = employee.getTelephones().get( 1 ).getPnumber();
		dddtel = tel.split( " " );
		employee.getTelephones().get( 1 ).setDdd( dddtel[0].substring( 1, 3 ) );
		employee.getTelephones().get( 1 ).setPnumber( dddtel[1].replace( "-", "" ) );

		return employee;
	}

	@Override
	public void clearFilter() {
		filter = new EmployeeFilter();
		filter.setStatus( "TODOS" );
	}

	// Getters e Setters

	public EmployeeFilter getFilter() {
		return filter;
	}

	public void setFilter( EmployeeFilter filter ) {
		this.filter = filter;
	}

	public List < Employee > getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList( List < Employee > employeeList ) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee( Employee employee ) {
		this.employee = employee;
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

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee( Employee selectedEmployee ) {
		this.selectedEmployee = selectedEmployee;
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

	public String getStatus() {
		return status;
	}

	public void setStatus( String status ) {
		this.status = status;
	}

}
