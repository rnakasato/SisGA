package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="bottomBeans")

public class BottomBeans {
	private String sistema = "SisGA - Sistema de Gestão Agrícola 2016";
	
	public String getSistema(){
		return sistema;
	}
}
