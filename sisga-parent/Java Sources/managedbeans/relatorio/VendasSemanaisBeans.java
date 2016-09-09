package managedbeans.relatorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@SessionScoped
@ManagedBean(name="vendasSemanaisBeans")


public class VendasSemanaisBeans {
         
    private String[] anosSelecionados, mesesSelecionados, produtosSelecionados, clientesSelecionados;   
    
	private List<String> anos, meses, produtos, clientes;
     
    @PostConstruct
    public void init() {
    	
        anos = new ArrayList<String>();
        anos.add("2006");
        anos.add("2007");
        anos.add("2008");
        anos.add("2009");
        anos.add("2010");
        anos.add("2011");
        anos.add("2012");
        anos.add("2013");
        anos.add("2014");
        anos.add("2015");
        anos.add("2016");
        
        meses = new ArrayList<String>();
        meses.add("Janeiro");
        meses.add("Fevereiro");
        meses.add("Março");
        meses.add("Abril");
        meses.add("Maio");
        meses.add("Junho");
        meses.add("Julho");
        meses.add("Agosto");
        meses.add("Setembro");
        meses.add("Outubro");
        meses.add("Novembro");
        meses.add("Dezembro");

        produtos = new ArrayList<String>();
        produtos.add("Bolo");
        produtos.add("Pudim");
        produtos.add("Torta");
        
        clientes = new ArrayList<String>();
        clientes.add("João");
        clientes.add("Pedro");
        clientes.add("Julia");
        
    }
 
    public String[] getAnosSelecionados() {
        return anosSelecionados;
    }
 
    public void setAnosSelecionados(String[] selectedAnos) {
        this.anosSelecionados = selectedAnos;
    }
 
    public List<String> getAnos() {
        return anos;
    }
    public String[] getMesesSelecionados() {
        return mesesSelecionados;
    }
 
    public void setMesesSelecionados(String[] selectedMeses) {
        this.mesesSelecionados = selectedMeses;
    }
 
    public List<String> getMeses() {
        return meses;
    }
    public String[] getProdutosSelecionados() {
        return produtosSelecionados;
    }
 
    public void setProdutosSelecionados(String[] selectedProdutos) {
        this.produtosSelecionados = selectedProdutos;
    }
 
    public List<String> getProdutos() {
        return produtos;
    }

	public String[] getClientesSelecionados() {
		return clientesSelecionados;
	}

	public void setClientesSelecionados(String[] selectedClientes) {
		this.clientesSelecionados = selectedClientes;
	}

	public List<String> getClientes() {
		return clientes;
	}
}