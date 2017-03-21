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

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.communication.PhoneType;
import com.sisga.domain.communication.Telephone;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.filter.CustomerFilter;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.EmployeeHistory;
import com.sisga.domain.employee.EmployeeOperation;
import com.sisga.domain.employee.filter.EmployeeFilter;
import com.sisga.web.util.Redirector;

/**
 * @author Sergio Massao Umiji 20 de mar de 2017
 */
@ManagedBean(name = "employeeMB")
@ViewScoped
public class EmployeeMB extends BaseMB {

	private static final long serialVersionUID = 1L;

	// utilizado para consulta de funcionarios
	private EmployeeFilter filter;
	private List<Employee> employeeList;

	// utilizado para cadastrar e alterar funcionarios
	private Employee employee;
	private String telephone;
	private String celular;
	private String status;
	private String code;
	private boolean doUpdate;

	// Para manipulação de funcionarios
	private Employee selectedEmployee;

	@PostConstruct
	public void init() {

		filter = new EmployeeFilter();
		employee = new Employee();
		employee.setTelephones(new ArrayList<Telephone>());
		doUpdate = false;
	}

	// Métodos Operacionais
	public void save() {
		prepareEmployee();
		ICommand commandSave;
		try {

			commandSave = FactoryCommand.build(employee, EOperation.SAVE);
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if (StringUtils.isNotEmpty(result.getMsg())) {
				ctx.addMessage(null, new FacesMessage(result.getMsg(), result.getMsg()));
			} else {
				ctx.addMessage(null, new FacesMessage("Funcionário cadastrado com código: " + employee.getCode()));

				EmployeeHistory history = new EmployeeHistory();
				history.setEmployee(employee);
				history.setOperationCode(EmployeeOperation.CADASTRO_FUNCIONARIO);
				commandSave = FactoryCommand.build(history, EOperation.SAVE);
				Result historyResult = commandSave.execute();

				if (StringUtils.isNotEmpty(result.getMsg())) {
					ctx.addMessage(null, new FacesMessage(historyResult.getMsg(), historyResult.getMsg()));
				}

				Flash flash = ctx.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				Redirector.redirectTo(ctx.getExternalContext(),
						"/pages/gestao/funcionarios/consultarFuncionarios.jsf?faces-redirect=true");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update() {
		prepareEmployee();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build(employee, EOperation.UPDATE);
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if (StringUtils.isNotEmpty(result.getMsg())) {
				ctx.addMessage(null, new FacesMessage(result.getMsg(), result.getMsg()));
			} else {
				ctx.addMessage(null, new FacesMessage("Funcionário Alterado"));

				EmployeeHistory history = new EmployeeHistory();
				history.setEmployee(employee);
				history.setOperationCode(EmployeeOperation.ALTERACAO_FUNCIONARIO);
				commandUpdate = FactoryCommand.build(history, EOperation.SAVE);
				Result historyResult = commandUpdate.execute();

				if (StringUtils.isNotEmpty(result.getMsg())) {
					ctx.addMessage(null, new FacesMessage(historyResult.getMsg(), historyResult.getMsg()));
				}
				Flash flash = ctx.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				Redirector.redirectTo(ctx.getExternalContext(),
						"/pages/gestao/funcionarios/consultarFuncionarios.jsf?faces-redirect=true");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(Employee employee) {
		ICommand commandUpdate;
		try {
			employee.setActive(false);
			commandUpdate = FactoryCommand.build(employee, EOperation.UPDATE);
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if (StringUtils.isNotEmpty(result.getMsg())) {
				ctx.addMessage(null, new FacesMessage(result.getMsg(), result.getMsg()));
			} else {
				ctx.addMessage(null, new FacesMessage("Funcionário deletado"));

				EmployeeHistory history = new EmployeeHistory();
				history.setEmployee(employee);
				history.setOperationCode(EmployeeOperation.EXCLUSAO_FUNCIONARIO);
				commandUpdate = FactoryCommand.build(history, EOperation.SAVE);
				Result historyResult = commandUpdate.execute();

				if (StringUtils.isNotEmpty(result.getMsg())) {
					ctx.addMessage(null, new FacesMessage(historyResult.getMsg(), historyResult.getMsg()));
				}
				search();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancel() {
		Redirector.redirectTo(FacesContext.getCurrentInstance().getExternalContext(),
				"/pages/gestao/funcionarios/consultarFuncionarios.jsf?faces-redirect=true");
	}

	public void search() {
		try {
			filter.setStatus(status);
			ICommand commandFind = FactoryCommand.build(filter, EOperation.FIND);
			employeeList = commandFind.execute().getEntityList();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Métodos de view (para auxiliar carregamentos de dados na view)
	public void redirectToEmployeeUpdate(Employee employee) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext context = ctx.getExternalContext();
		if (employee != null) {

			context.getFlash().put("employee", employee);
			StringBuilder sb = new StringBuilder();
			sb.append("/pages/gestao/funcionarios/alterarFuncionarios.jsf?faces-redirect=true");
			sb.append("&employeeCode=");
			sb.append(employee.getCode());

			String url = sb.toString();
			Redirector.redirectTo(context, url);

		} else {
			ctx.addMessage(null, new FacesMessage("Selecione um funcionário para alterar"));
		}
	}

	public void loadEmployee() {
		try {
			doUpdate = true;
			if (!StringUtils.isEmpty(code)) {
				EmployeeFilter filter = new EmployeeFilter();
				filter.setCode(code);
				ICommand commandFind;
				commandFind = FactoryCommand.build(filter, EOperation.FIND);
				List<Employee> employeeList = commandFind.execute().getEntityList();
				if (employeeList != null && !employeeList.isEmpty()) {
					employee = employeeList.get(0);
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void viewDetails(Employee employee) {
		selectedEmployee = employee;
	}

	private Employee prepareEmployee() {
		Telephone tel = new Telephone();
		Telephone cel = new Telephone();

		PhoneType type = new PhoneType();

		tel.setPnumber(telephone);
		type.setDescription(PhoneType.TELEFONE);
		tel.setPhoneType(type);
		employee.setTelephones(new ArrayList<Telephone>());
		employee.getTelephones().add(tel);

		cel.setPnumber(celular);
		type.setDescription(PhoneType.CELULAR);
		cel.setPhoneType(type);
		employee.getTelephones().add(cel);

		return employee;
	}

	@Override
	public void clearFilter() {
		filter = new EmployeeFilter();
	}

	// Getters e Setters

	public EmployeeFilter getFilter() {
		return filter;
	}

	public void setFilter(EmployeeFilter filter) {
		this.filter = filter;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

}
