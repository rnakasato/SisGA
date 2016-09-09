package managedbeans.clientes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Cliente;

@SessionScoped
@ManagedBean(name = "cadastrarClientesBeans")

public class CadastrarClientesBeans {
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<String> proprietarios;
	private List<String> associarClienteA;

	@PostConstruct
	private void init() {

		proprietarios = new ArrayList<String>();
		proprietarios.add("Marcelo");
		proprietarios.add("Antonio");
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public List<String> getProprietarios() {
		return proprietarios;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<String> getAssociarClienteA() {
		return associarClienteA;
	}

	public void setAssociarClienteA(List<String> associarClienteA) {
		this.associarClienteA = associarClienteA;
	}

	public void cadastrar() {
		// TODO Auto-generated method stub
	}

	public void cancelar() {
		// TODO Auto-generated method stub

	}

	
}
