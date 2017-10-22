package com.sisga.web.mb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sisga.core.core.util.FormatUtils;

@ManagedBean( name = "formatterMB" )
@SessionScoped
public class FormatterMB {
	public String formatCurrency( Double price ) {
		return FormatUtils.formatToCurrency( price );
	}

	public String formatToPercentage( Double value ) {
		return FormatUtils.formatToPercentage( value );
	}

	public String formatDate( Calendar calendar ) {
		String formatted = null;
		
		if(calendar != null) {
			formatted = formatFromDate( calendar.getTime() ); 
		}
			
		return formatted;
	}

	public String formatDateTime( Calendar calendar ) {
		String formatted = null;
		
		if(calendar != null) {
			formatted = formatFromDateTime( calendar.getTime() ); 
		}
		
		return formatted;
	}

	public String formatFromDate( Date date ) {
		String formattedDate = null;
		if( date != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
			formattedDate = sdf.format( date );
		}
		return formattedDate;
	}

	public String formatFromDateTime( Date date ) {
		String formattedDate = null;
		if( date != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyy HH:mm:ss" );
			formattedDate = sdf.format( date );
		}
		return formattedDate;
	}

	public String formatCEP( String value ) {
		return FormatUtils.formatString( value, "#####-###" );
	}

}
