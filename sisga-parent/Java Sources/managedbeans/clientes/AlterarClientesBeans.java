package managedbeans.clientes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Cliente;

@SessionScoped
@ManagedBean(name = "alterarClientesBeans")

public class AlterarClientesBeans {
	private List<Cliente> clientes;
	private Cliente cliente;
	private String associarClienteA;
	private List<String> proprietarios;
	
	@PostConstruct
	private void init() {
		proprietarios = new ArrayList<String>();
		proprietarios.add("Marcelo");
		proprietarios.add("Antonio");
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public List<String> getProprietarios(){
		return proprietarios;
	}

	public String getAssociarClienteA() {
		return associarClienteA;
	}

	public void setAssociarClienteA(String associarClienteA) {
		this.associarClienteA = associarClienteA;
	}

	public void alterar() {

	}

	public void cancelar() {

	}

}
