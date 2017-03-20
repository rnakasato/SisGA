package com.sisga.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sisga.core.ICommand;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.communication.PhoneType;
import com.sisga.domain.communication.Telephone;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.filter.EmployeeFilter;

/**
 * 
 * @author Sergio Massao Umiji 
 * 16 de mar de 2017
 */

@SessionScoped
@ManagedBean(name="listarFuncionariosMB")

public class GestaoFuncionariosMB {

	private List<Employee> employees = null;
	private Employee employee;
	private EmployeeFilter employeeFilter;
	private Telephone phone;
	private Telephone cellphone;
	
	

	@PostConstruct
	private void init(){
		employeeFilter = new EmployeeFilter();
		employeeFilter.setName("");
		employees = new ArrayList<Employee>();
		
		try {
			ICommand commandFindAll = FactoryCommand.build( new Employee(), EOperation.FINDALL );
			employees = commandFindAll.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void find() {
		
		try {
			ICommand commandFind = FactoryCommand.build( employeeFilter, EOperation.FIND );
			employees = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public void add() {
		employee = new Employee();
		cellphone = new Telephone();
		phone = new Telephone();  
		cellphone.setPnumber("");
		cellphone.setPhoneType(new PhoneType());
		cellphone.getPhoneType().setCode(PhoneType.CELULAR);
		phone.setPnumber("");
		phone.setPhoneType(new PhoneType());
		phone.getPhoneType().setCode(PhoneType.TELEFONE);
	}

	public void save() {
		employee.setTelephones(new ArrayList<Telephone>());
		employee.getTelephones().add(phone);
		employee.getTelephones().add(cellphone);
		try {
			ICommand commandAdd = FactoryCommand.build( employee, EOperation.SAVE );
			try {
				ICommand commandFindAll = FactoryCommand.build( new Employee(), EOperation.FINDALL );
				employees = commandFindAll.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			ICommand commandAlt = FactoryCommand.build( employee, EOperation.UPDATE );
			try {
				ICommand commandFindAll = FactoryCommand.build( new Employee(), EOperation.FINDALL );
				employees = commandFindAll.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void alter(Employee employee) {
		this.employee = employee;
	}

	public void del(Employee employee) {
		try {
			ICommand commandDel = FactoryCommand.build( employee, EOperation.DELETE );
			try {
				ICommand commandFindAll = FactoryCommand.build( new Employee(), EOperation.FINDALL );
				employees = commandFindAll.execute().getEntityList();
			} catch( ClassNotFoundException e ) {
				e.printStackTrace();
			}
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void details(Employee employee) {
		this.employee = employee;
	}
	
	public void cleanFilters() {
		employeeFilter = new EmployeeFilter();
		employeeFilter.setName("");
		employees = new ArrayList<Employee>();
		
		try {
			ICommand commandFindAll = FactoryCommand.build( new Employee(), EOperation.FINDALL );
			employees = commandFindAll.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	

	//getters and setters
	
	public void detail(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeFilter getEmployeeFilter() {
		return employeeFilter;
	}

	public void setEmployeeFilter(EmployeeFilter employeeFilter) {
		this.employeeFilter = employeeFilter;
	}
	
	public Telephone getPhone() {
		return phone;
	}

	public void setPhone(Telephone phone) {
		this.phone = phone;
	}

	public Telephone getCellphone() {
		return cellphone;
	}

	public void setCellphone(Telephone cellphone) {
		this.cellphone = cellphone;
	}
	

}
