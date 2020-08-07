package com.cineapp.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Utileria {

	
	public static List<String> getNextDays(int count){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Today´s Date
		Date finicio = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.DAY_OF_MONTH, count);
		Date ffinal = calendario.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(finicio);
		List<String>diasSiguientes = new ArrayList<String>();
		while (!gcal.getTime().after(ffinal)) {
			Date fecha = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			diasSiguientes.add(sdf.format(fecha));
		}
		
		return diasSiguientes;
		
	}
	
}
