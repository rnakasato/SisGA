package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.product.TipoProducao;

public class TipoProducaoDAO extends AbstractDAO<TipoProducao>{

	@Override
	public List<TipoProducao> find(TipoProducao entity) throws Exception {
		// TODO refazer, foi utilizado para teste
		return findAll();
	}

	@Override
	public List<TipoProducao> findAll() throws Exception {
		List<TipoProducao> tipoProducaoList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append(" FROM TipoProducao ");

			Query query = session.createQuery(jpql.toString());

			tipoProducaoList = query.getResultList();

			closeSession();
		} catch (RuntimeException e) {
			cancelSession();
		}
		return tipoProducaoList;

	}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		ICommand command = FactoryCommand.build(new TipoProducao(), EOperation.FIND);
		Result result = command.execute();
		List<TipoProducao> listTipo = result.getEntityList();
		if(listTipo != null){
			for (TipoProducao tipoProducao : listTipo) {
				System.out.println(tipoProducao.getDescription());
			}
		}
		
		System.exit(0);
		
	}
}
