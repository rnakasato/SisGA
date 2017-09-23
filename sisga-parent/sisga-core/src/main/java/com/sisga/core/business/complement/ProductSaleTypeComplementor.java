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

				// Para montar o c�digo da nova forma de venda utiliza-se:
				// Os primeiros 3 caracteres em caixa alta da descri��o da
				// forma
				// de venda. Ex: CAIXA - c�d: CAI

				// Caso j� exista um produto com o mesmo c�digo, ser�
				// utilizado:
				// Os primerios 3 caracteres em caixa alta da descri��o e um
				// valor num�rico. Ex: CAIXA PAPELAO - c�d: CAI1

				// Ocorrer� a verifica��o at� que haja um nome dispon�vel.
				// Ex:
				// CAI2, CAI3, CAI4 ...CAI9
				// Caso chegue no valor num�rico 9 ap�s os caracteres,
				// ocorrer�
				// um erro.
				// Foi definido dessa forma porque pequenos produtores não
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
						// Existe uma forma de venda com o mesmo c�digo
						StringBuilder sb = new StringBuilder();
						sb.append( code.substring( 0, 2 ) );
						sb.append( count );
						code = sb.toString();
						count ++ ;
					} else {
						// Não existe forma de venda com o mesmo c�digo,
						// poder�
						// ser
						// utilizado �ltimo c�digo gerado
						validCode = true;
						newSaleType.setCode( code.toUpperCase() );
					}
				}

				if( ! validCode && count > 9 ) {
					// Foram excedidos os c�digos com os 3 d�gitos iniciais da
					// forma de venda
					// EX: foi gerado o c�d: CAI9
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
