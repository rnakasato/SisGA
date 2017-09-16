package com.sisga.web.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.core.util.ImageUtils;
import com.sisga.core.core.util.ListUtils;
import com.sisga.core.core.util.SaveDirectory;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductHistory;
import com.sisga.domain.product.ProductOperation;
import com.sisga.domain.product.ProductionType;
import com.sisga.domain.product.SaleType;
import com.sisga.domain.product.StockType;
import com.sisga.domain.product.filter.ProductFilter;
import com.sisga.domain.product.filter.SaleTypeFilter;
import com.sisga.domain.product.filter.StockTypeFilter;
import com.sisga.web.util.Redirector;

/**
 * @author Rafael Hikaru Nakasato
 *         17 de mar de 2017
 */
@ManagedBean( name = "productMB" )
@ViewScoped
public class ProductMB extends BaseMB {

	private static final long serialVersionUID = 1L;

	// utilizado para consulta de produtos
	private ProductFilter filter;
	private List < Product > productList;

	// utilizado para cadastrar e alterar produtos
	private Product product;
	private String saleTypeDescription;
	private String code;
	private Long addAmount;
	private Long removeAmount;
	private boolean doUpdate;
	// Para manipulação de produtos
	private Product selectedProduct;

	private List < StockType > stockTypeList;
	private List < ProductionType > productionTypeList;
	private List < SaleType > saleTypeList;

	@PostConstruct
	public void init() {
		initSaleType();
		initProductionType();

		filter = new ProductFilter();
		product = new Product();
		product.setSaleType( new SaleType() );
		product.setProductionType( productionTypeList.get( 0 ) );

		doUpdate = false;
		initStockType();

	}

	// Métodos Operacionais
	public void save() {
		
		prepareProduct();
		ICommand commandSave;
		try {

			commandSave = FactoryCommand.build( product, EOperation.SAVE );
			Result result = commandSave.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Produto cadastrado com código: " + product.getCode() ) );

				ProductHistory history = new ProductHistory();
				history.setProduct( product );
				history.setOperationCode( ProductOperation.CADASTRO_PRODUTO );
				commandSave = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandSave.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}

				if(getSaveDialog() != null){
		            RequestContext.getCurrentInstance().execute( "PF('" + getSaveDialog().getWidgetVar() + "').hide();" );
				}

			}

		} catch( ClassNotFoundException e ) {

			e.printStackTrace();
		}

	}

	public void update() {
		prepareProduct();
		ICommand commandUpdate;
		try {
			commandUpdate = FactoryCommand.build( product, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );				
			} else {
				ctx.addMessage( null, new FacesMessage( "Produto Alterado" ) );

				ProductHistory history = new ProductHistory();
				history.setProduct( product );
				history.setOperationCode( ProductOperation.ALTERACAO_DADOS_PRODUTO );
				commandUpdate = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandUpdate.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}
				
				if(getUpdateDialog() != null){
		            RequestContext.getCurrentInstance().execute( "PF('" + getUpdateDialog().getWidgetVar() + "').hide();" );
				}
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete( Product product ) {
		ICommand commandUpdate;
		try {
			product.setActive( false );
			commandUpdate = FactoryCommand.build( product, EOperation.UPDATE );
			Result result = commandUpdate.execute();

			FacesContext ctx = FacesContext.getCurrentInstance();

			if( StringUtils.isNotEmpty( result.getMsg() ) ) {
				ctx.addMessage( null, new FacesMessage( result.getMsg(), result.getMsg() ) );
			} else {
				ctx.addMessage( null, new FacesMessage( "Produto deletado" ) );

				ProductHistory history = new ProductHistory();
				history.setProduct( product );
				history.setOperationCode( ProductOperation.EXCLUSAO_PRODUTO );
				commandUpdate = FactoryCommand.build( history, EOperation.SAVE );
				Result historyResult = commandUpdate.execute();

				if( StringUtils.isNotEmpty( result.getMsg() ) ) {
					ctx.addMessage( null, new FacesMessage( historyResult.getMsg(), historyResult.getMsg() ) );
				}
				search();
			}

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancel() {
		Redirector.redirectTo( FacesContext.getCurrentInstance().getExternalContext(),
				"/pages/gestao/produtos/consultarProdutos.jsf?faces-redirect=true" );

	}

	public void search() {
		try {
			filter.setActive( true );
			ICommand commandFind = FactoryCommand.build( filter, EOperation.FIND );
			productList = commandFind.execute().getEntityList();

		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Métodos de view (para auxiliar carregamentos de dados na view)
	public void redirectToProductUpdate( Product product ) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext context = ctx.getExternalContext();
		if( product != null ) {

			context.getFlash().put( "product", product );
			StringBuilder sb = new StringBuilder();
			sb.append( "/pages/gestao/produtos/alterarProdutos.jsf?faces-redirect=true" );
			sb.append( "&productCode=" );
			sb.append( product.getCode() );

			String url = sb.toString();
			Redirector.redirectTo( context, url );

		} else {
			ctx.addMessage( null, new FacesMessage( "Selecione um produto para alterar" ) );
		}
	}

	public void setUpdate(Product product) {
		
			doUpdate = true;
			addAmount = 0L;
			removeAmount = 0L;
			
			this.product = product;
			

	}

	public void loadStockType() {
		ICommand commandFind = null;
		try {
			if( product.getProductionType() != null ) {
				StockTypeFilter filter = new StockTypeFilter();
				commandFind = FactoryCommand.build( filter, EOperation.FIND );

				if( product.getProductionType().getCode().equals( ProductionType.MUDAS ) ) {
					filter.setCode( StockType.BANDEJA );
				} else {
					filter.setCode( StockType.LATA );
				}
				List < StockType > stockTypeList = commandFind.execute().getEntityList();
				if( ListUtils.isNotEmpty( stockTypeList ) ) {
					product.setStockType( stockTypeList.get( 0 ) );
				}
			}
		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List < String > fillSaleType( String query ) {
		List < String > acSaleType = null;
		SaleTypeFilter filter = new SaleTypeFilter();
		filter.setDescription( query );

		try {
			ICommand command;
			command = FactoryCommand.build( filter, EOperation.FIND );
			List < SaleType > stList = command.execute().getEntityList();
			acSaleType = new ArrayList<>();
			if( ! ListUtils.isEmpty( stList ) ) {
				for( SaleType s: stList ) {
					acSaleType.add( s.getDescription() );
				}
			}
		} catch( ClassNotFoundException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return acSaleType;
	}

	public void viewDetails( Product product ) {
		selectedProduct = product;
	}

	private Product prepareProduct() {
		SaleType st = new SaleType();
		st.setDescription( saleTypeDescription );
		product.setSaleType( st );
		if( doUpdate ) {
			Long newAmount = product.getAmount() + addAmount - removeAmount;
			product.setAmount( newAmount );
		}

		return product;
	}

	public void doUpload( FileUploadEvent event ) {
		FacesMessage msg = new FacesMessage( "Arquivo salvo! ", event.getFile().getFileName() + " is uploaded." );
		FacesContext.getCurrentInstance().addMessage( null, msg );

		try {
			ImageUtils.copyImage( event.getFile().getFileName(), event.getFile().getInputstream() );
			String image = event.getFile().getFileName();
			product.setPhoto( image );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearFilter() {
		filter = new ProductFilter();
	}

	// Métodos para inicialização do MB
	public void initStockType() {
		loadStockType();
	}

	public void initSaleType() {
		try {
			ICommand commandFind = FactoryCommand.build( new SaleType(), EOperation.FINDALL );
			saleTypeList = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public void initProductionType() {
		try {
			ICommand commandFind = FactoryCommand.build( new ProductionType(), EOperation.FINDALL );
			productionTypeList = commandFind.execute().getEntityList();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public String getImagePath( Product product ) {
		String path;
		if( product != null && product.getPhoto() != null ) {
			path = SaveDirectory.REQUEST_IMG_DIR + product.getPhoto();
		} else {
			path = "default.jpg";
		}
		return path;
	}

	// Getters e Setters
	public ProductFilter getFilter() {
		return filter;
	}

	public void setFilter( ProductFilter filter ) {
		this.filter = filter;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct( Product product ) {
		this.product = product;
	}

	public List < StockType > getStockTypeList() {
		return stockTypeList;
	}

	public void setStockTypeList( List < StockType > stockTypeList ) {
		this.stockTypeList = stockTypeList;
	}

	public List < ProductionType > getProductionTypeList() {
		return productionTypeList;
	}

	public void setProductionTypeList( List < ProductionType > productionTypeList ) {
		this.productionTypeList = productionTypeList;
	}

	public List < SaleType > getSaleTypeList() {
		return saleTypeList;
	}

	public void setSaleTypeList( List < SaleType > saleTypeList ) {
		this.saleTypeList = saleTypeList;
	}

	public String getSaleTypeDescription() {
		return saleTypeDescription;
	}

	public void setSaleTypeDescription( String saleTypeDescription ) {
		this.saleTypeDescription = saleTypeDescription;
	}

	public List < Product > getProductList() {
		return productList;
	}

	public void setProductList( List < Product > productList ) {
		this.productList = productList;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct( Product selectedProduct ) {
		this.selectedProduct = selectedProduct;
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public Long getAddAmount() {
		return addAmount;
	}

	public void setAddAmount( Long addAmount ) {
		this.addAmount = addAmount;
	}

	public Long getRemoveAmount() {
		return removeAmount;
	}

	public void setRemoveAmount( Long removeAmount ) {
		this.removeAmount = removeAmount;
	}

	public boolean isDoUpdate() {
		return doUpdate;
	}

	public void setDoUpdate( boolean doUpdate ) {
		this.doUpdate = doUpdate;
	}

}
