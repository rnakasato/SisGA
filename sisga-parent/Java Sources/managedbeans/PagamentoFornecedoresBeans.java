package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@SessionScoped
@ManagedBean(name="pagamentoFornecedoresBeans")


public class PagamentoFornecedoresBeans {
         
    private String[] anosVencimentoSelecionados, anosPagamentoSelecionados, 
    mesesVencimentoSelecionados, mesesPagamentoSelecionados, fornecedoresSelecionados;   
    
	private List<String> anosVencimento, anosPagamento, mesesVencimento, mesesPagamento, fornecedores;
    
	private Object pagamentoForncedores;
	
    @PostConstruct
    public void init() {
        anosVencimento = new ArrayList<String>();
        anosVencimento.add("2006");
        anosVencimento.add("2007");
        anosVencimento.add("2008");
        anosVencimento.add("2009");
        anosVencimento.add("2010");
        anosVencimento.add("2011");
        anosVencimento.add("2012");
        anosVencimento.add("2013");
        anosVencimento.add("2014");
        anosVencimento.add("2015");
        anosVencimento.add("2016");
        
        mesesVencimento = new ArrayList<String>();
        mesesVencimento.add("Janeiro");
        mesesVencimento.add("Fevereiro");
        mesesVencimento.add("Março");
        mesesVencimento.add("Abril");
        mesesVencimento.add("Maio");
        mesesVencimento.add("Junho");
        mesesVencimento.add("Julho");
        mesesVencimento.add("Agosto");
        mesesVencimento.add("Setembro");
        mesesVencimento.add("Outubro");
        mesesVencimento.add("Novembro");
        mesesVencimento.add("Dezembro");

        anosPagamento = new ArrayList<String>();
        anosPagamento.add("2006");
        anosPagamento.add("2007");
        anosPagamento.add("2008");
        anosPagamento.add("2009");
        anosPagamento.add("2010");
        anosPagamento.add("2011");
        anosPagamento.add("2012");
        anosPagamento.add("2013");
        anosPagamento.add("2014");
        anosPagamento.add("2015");
        anosPagamento.add("2016");
        
        mesesPagamento = new ArrayList<String>();
        mesesPagamento.add("Janeiro");
        mesesPagamento.add("Fevereiro");
        mesesPagamento.add("Março");
        mesesPagamento.add("Abril");
        mesesPagamento.add("Maio");
        mesesPagamento.add("Junho");
        mesesPagamento.add("Julho");
        mesesPagamento.add("Agosto");
        mesesPagamento.add("Setembro");
        mesesPagamento.add("Outubro");
        mesesPagamento.add("Novembro");
        mesesPagamento.add("Dezembro");

        fornecedores = new ArrayList<String>();
        fornecedores.add("Sabesp");
        fornecedores.add("Bandeirante");
        fornecedores.add("Vivo");
        
    }

	public String[] getAnosVencimentoSelecionados() {
		return anosVencimentoSelecionados;
	}

	public void setAnosVencimentoSelecionados(String[] anosVencimentoSelecionados) {
		this.anosVencimentoSelecionados = anosVencimentoSelecionados;
	}

	public String[] getAnosPagamentoSelecionados() {
		return anosPagamentoSelecionados;
	}

	public void setAnosPagamentoSelecionados(String[] anosPagamentoSelecionados) {
		this.anosPagamentoSelecionados = anosPagamentoSelecionados;
	}

	public String[] getMesesVencimentoSelecionados() {
		return mesesVencimentoSelecionados;
	}

	public void setMesesVencimentoSelecionados(String[] mesesVencimentoSelecionados) {
		this.mesesVencimentoSelecionados = mesesVencimentoSelecionados;
	}

	public String[] getMesesPagamentoSelecionados() {
		return mesesPagamentoSelecionados;
	}

	public void setMesesPagamentoSelecionados(String[] mesesPagamentoSelecionados) {
		this.mesesPagamentoSelecionados = mesesPagamentoSelecionados;
	}

	public String[] getFornecedoresSelecionados() {
		return fornecedoresSelecionados;
	}

	public void setFornecedoresSelecionados(String[] fornecedoresSelecionados) {
		this.fornecedoresSelecionados = fornecedoresSelecionados;
	}

	public List<String> getAnosVencimento() {
		return anosVencimento;
	}

	public List<String> getAnosPagamento() {
		return anosPagamento;
	}

	public List<String> getMesesVencimento() {
		return mesesVencimento;
	}

	public List<String> getMesesPagamento() {
		return mesesPagamento;
	}

	public List<String> getFornecedores() {
		return fornecedores;
	}
	
	public Object consultarPagamentoFornecedores(){
		return pagamentoForncedores;
	}
}