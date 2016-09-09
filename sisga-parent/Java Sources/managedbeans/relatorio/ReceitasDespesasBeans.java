package managedbeans.relatorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@SessionScoped
@ManagedBean(name="receitasDespesasBeans")


public class ReceitasDespesasBeans {
         
    private String[] anosSelecionados, mesesSelecionados, despesasSelecionados;   
    
	private List<String> anos, meses, despesas;
     
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
        meses.add("Mar�o");
        meses.add("Abril");
        meses.add("Maio");
        meses.add("Junho");
        meses.add("Julho");
        meses.add("Agosto");
        meses.add("Setembro");
        meses.add("Outubro");
        meses.add("Novembro");
        meses.add("Dezembro");

        despesas = new ArrayList<String>();
        despesas.add("Agua");
        despesas.add("Luz");
        despesas.add("Telefone");
        
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
    public String[] getDespesasSelecionados() {
        return despesasSelecionados;
    }
 
    public void setDespesasSelecionados(String[] selectedDespesas) {
        this.despesasSelecionados = selectedDespesas;
    }
 
    public List<String> getDespesas() {
        return despesas;
    }
    
}