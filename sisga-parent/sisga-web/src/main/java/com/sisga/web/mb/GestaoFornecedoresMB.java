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
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.filter.ProviderFilter;

/**
 * 
 * @author Sergio Massao Umiji 15 de mar de 2017
 */

@SessionScoped
@ManagedBean(name = "listarFornecedoresMB")

public class GestaoFornecedoresMB {

	private List<Provider> providers = null;
	private Provider provider;
	private ProviderFilter providerFilter;
	private Telephone phone;
	private Telephone cellphone;

	@PostConstruct
	private void init() {
		providerFilter = new ProviderFilter();
		providerFilter.setName("");
		providers = new ArrayList<Provider>();

		try {
			ICommand commandFindAll = FactoryCommand.build(new Provider(), EOperation.FINDALL);
			providers = commandFindAll.execute().getEntityList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void find() {
		try {
			ICommand commandFind = FactoryCommand.build(providerFilter, EOperation.FIND);
			providers = commandFind.execute().getEntityList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		provider = new Provider();
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
		provider.setTelephones(new ArrayList<Telephone>());
		provider.getTelephones().add(phone);
		provider.getTelephones().add(cellphone);
		try {
			ICommand commandAdd = FactoryCommand.build(provider, EOperation.SAVE);
			try {
				ICommand commandFindAll = FactoryCommand.build(new Provider(), EOperation.FINDALL);
				providers = commandFindAll.execute().getEntityList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			ICommand commandAlt = FactoryCommand.build(provider, EOperation.UPDATE);
			try {
				ICommand commandFindAll = FactoryCommand.build(new Provider(), EOperation.FINDALL);
				providers = commandFindAll.execute().getEntityList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void alter(Provider provider) {
		this.provider = provider;
	}

	public void del(Provider provider) {
		try {
			ICommand commandDel = FactoryCommand.build(provider, EOperation.DELETE);
			try {
				ICommand commandFindAll = FactoryCommand.build(new Provider(), EOperation.FINDALL);
				providers = commandFindAll.execute().getEntityList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void details(Provider provider) {
		this.provider = provider;
	}

	public void cleanFilters() {
		providerFilter = new ProviderFilter();
		providerFilter.setName("");
		providers = new ArrayList<Provider>();

		try {
			ICommand commandFindAll = FactoryCommand.build(new Provider(), EOperation.FINDALL);
			providers = commandFindAll.execute().getEntityList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// getters and setters
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ProviderFilter getProviderFilter() {
		return providerFilter;
	}

	public void setProviderFilter(ProviderFilter providerFilter) {
		this.providerFilter = providerFilter;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
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

	public List<Provider> getProviders() {
		return providers;
	}
}
