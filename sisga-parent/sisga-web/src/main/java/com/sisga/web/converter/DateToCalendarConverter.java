package com.sisga.web.converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "calendarConverter")
public class DateToCalendarConverter implements Converter{
	
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Object getAsObject( FacesContext arg0, UIComponent arg1, String arg2 ) {
		df.setLenient(false);
        try {
        	Date date = df.parse(arg2);
        	Calendar calendar = Calendar.getInstance();
        	if(date != null) {
        		calendar.setTime( date );	
        	}        	
        	
            return calendar;            
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão de data","Erro de conversão de data")); 
        }
	}

	@Override
	public String getAsString( FacesContext arg0, UIComponent arg1, Object arg2 ) {
		try {
            df.setLenient(false);
            String date = df.format((Date) arg2);
            return date;
        } catch (Exception e) {
            return "";
        }
	}

}
