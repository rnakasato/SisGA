package managedbeans.clientes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Cliente;
import managedbeans.OperacoesBeans;

@SessionScoped
@ManagedBean(name="consultarClientesBeans")

public class ConsultarClientesBeans extends OperacoesBeans{
	private List<Cliente> clientes;
	
	@PostConstruct
	private void init(){
		clientes = new ArrayList<Cliente>();
		
		Cliente c1  = new Cliente();
		c1.setNome("Sergio");
		c1.setTelefone("4545-6767");
		c1.setCelular("978789090");
		c1.setStatus("A");
		clientes.add(c1);
		
		Cliente c2  = new Cliente();
		c2.setNome("Marcio");
		c2.setTelefone("4544-6709");
		c2.setCelular("978780987");
		c2.setStatus("A");
		clientes.add(c2);
	
		Cliente c3  = new Cliente();	
		c3.setNome("Raul");
		c3.setTelefone("4523-2267");
		c3.setCelular("978222090");
		c3.setStatus("I");
		clientes.add(c3);
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}

	@Override
	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detalhar() {
		// TODO Auto-generated method stub
		
	}
}
