package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.Message;
import com.sisga.core.dao.impl.SaleTypeDAO;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.SaleType;
import com.sisga.domain.product.filter.SaleTypeFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductSaleTypeComplementor extends Complementor < Product > {

	@Override
	public String complement( Product p ) {
		String saleTypeDescription = p.getSaleType().getDescription();

		SaleTypeFilter filter = new SaleTypeFilter();
		filter.setDescription( saleTypeDescription );

		SaleTypeDAO saleTypeDAO = new SaleTypeDAO();
		saleTypeDAO.setSession( SessionThreadLocal.getSession() );
		try {
			SaleType saleType = saleTypeDAO.findSingle( filter );
			if( saleType != null ) {
				p.setSaleType( saleType );
			} else {
				SaleType newSaleType = new SaleType();
				newSaleType.setDescription( saleTypeDescription );

				// Para montar o código da nova forma de venda utiliza-se:
				// Os primeiros 3 caracteres em caixa alta da descrição da
				// forma
				// de venda. Ex: CAIXA - cód: CAI

				// Caso já exista um produto com o mesmo código, será
				// utilizado:
				// Os primerios 3 caracteres em caixa alta da descrição e um
				// valor numérico. Ex: CAIXA PAPELAO - cód: CAI1

				// Ocorrerá a verificação até que haja um nome disponível.
				// Ex:
				// CAI2, CAI3, CAI4 ...CAI9
				// Caso chegue no valor numérico 9 após os caracteres,
				// ocorrerá
				// um erro.
				// Foi definido dessa forma porque pequenos produtores nÃ£o
				// produzem variedades muito
				// grandes de produtos e possuem muitas formas de venda, para
				// que ocorresse esse problema
				String code = saleTypeDescription.substring( 0, 2 );

				boolean validCode = false;
				int count = 1;

				while( ! validCode && count < 10 ) {
					filter = new SaleTypeFilter();
					filter.setCode( code );
					saleType = saleTypeDAO.findSingle( filter );

					if( saleType != null ) {
						// Existe uma forma de venda com o mesmo código
						StringBuilder sb = new StringBuilder();
						sb.append( code.substring( 0, 2 ) );
						sb.append( count );
						code = sb.toString();
						count ++ ;
					} else {
						// NÃ£o existe forma de venda com o mesmo código,
						// poderá
						// ser
						// utilizado Último código gerado
						validCode = true;
						newSaleType.setCode( code.toUpperCase() );
					}
				}

				if( ! validCode && count > 9 ) {
					// Foram excedidos os códigos com os 3 dígitos iniciais da
					// forma de venda
					// EX: foi gerado o cód: CAI9
					msg = Message.getMessage( "com.sisga.core.business.sale.code.exceeded", Message.ERROR, p);
				}

				if( validCode ) {
					saleTypeDAO.save( newSaleType );
					p.setSaleType(newSaleType);
				}

			}

		} catch( Exception e ) {
			msg = Message.getMessage( "com.sisga.core.unexpected.error", Message.ERROR, p);
		}

		return msg;
	}

}
