package com.sisga.core.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sisga.domain.product.TipoProducao;

public class ProdutoDAO extends AbstractDAO<TipoProducao>{
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();

		 SessionFactory factory = new Configuration().configure().buildSessionFactory();;  
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<TipoProducao> tipoProducaoList = session.createQuery("FROM TipoProducao").getResultList(); 
	         for (Iterator<TipoProducao> iterator = 
	        		 tipoProducaoList.iterator(); iterator.hasNext();){
	            TipoProducao tipoProducao = (TipoProducao) iterator.next();
	            System.out.println("Tipo Producao ID: " + tipoProducao.getId());
	            System.out.println("Tipo Producao: " + tipoProducao.getDescription());
	            System.out.println("Tipo Unidade ID: " + tipoProducao.getTipoUnidade().getId());
	            System.out.println("Tipo Unidade: " + tipoProducao.getTipoUnidade().getDescription());
	            System.out.println("Data Insercao: " + tipoProducao.getInsertDate());
	            System.out.println("\n");
	         }
	         tx.commit();
	         System.out.println("FIM");
	         TipoProducao tip = new TipoProducao();
	         tip.setId(1L);
	         dao.openSession();
	         TipoProducao test = dao.find(tip);
	         System.out.println(test.getDescription());
	         dao.closeSession();;
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close();
	         System.out.println("FIM");
	      }
	      Runtime.getRuntime().exit(0);
	             
	      
	}
}
