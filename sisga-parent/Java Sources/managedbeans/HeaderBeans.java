package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="headerBeans")

public class HeaderBeans {
	private String nome = "Nome da Empresa";
	private String telefone = "XXXX-XXXX";
	private String endereco = "XXX, XXX, XXX";
	
	public String getNome(){
		return nome;
	}
	public String getTelefone(){
		return telefone;
	}
	public String getEndereco(){
		return endereco;
	}
}
