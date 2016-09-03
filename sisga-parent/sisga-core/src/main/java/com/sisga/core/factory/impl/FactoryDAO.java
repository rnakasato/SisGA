package com.sisga.core.factory.impl;

import java.util.HashMap;
import java.util.Map;

import com.sisga.core.IDAO;
import com.sisga.core.dao.impl.ProdutoDAO;
import com.sisga.core.dao.impl.TipoProducaoDAO;
import com.sisga.domain.product.Produto;
import com.sisga.domain.product.TipoProducao;

public class FactoryDAO {
		
	private static Map<Class,IDAO> daoMap;
	
	private static void initMap(){
		if(daoMap == null){
			daoMap = new HashMap<>();
			daoMap.put(Produto.class, new ProdutoDAO());
			daoMap.put(TipoProducao.class, new TipoProducaoDAO());
		}
	}
	
	/**	 
	 * @param className
	 * @return retorna instância de DAO para o Objeto
	 */
	public static IDAO build(Class className) throws ClassNotFoundException{
		initMap();
		IDAO dao = daoMap.get(className);
		if(dao == null){
			throw new ClassNotFoundException();
		}
		return dao;
	}
}
