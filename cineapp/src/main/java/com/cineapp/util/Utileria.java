package com.cineapp.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

//	Regresa lista de String con las fechas siguientes
	public static List<String> getNextDays(int count){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Today�s Date
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
	
	
//	Guardar imagen
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		String nombreFinal = ramdomAlphaNumeric(8)+nombreOriginal;
//		reemplazar espacios por _
		nombreOriginal = nombreOriginal.replace(" ", "_");
		
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
		// Formamos el nombre del archivo para guardarlo en el disco duro
		File imageFile = new File(rutaFinal + nombreFinal);
//		Ruta Temporal de imagenes
		System.out.println(imageFile.getAbsolutePath());
		// Aqui se guarda fisicamente el archivo en el disco duro
		multiPart.transferTo(imageFile);
		return nombreFinal;
		} catch (IOException e) {
		System.out.println("Error " + e.getMessage());
		return null;
		}
		}
	
	//Metodo Genera cadena aleatoria de longitud N, se usa para generar nombres no repetidos en las imagenes
	
		public static String ramdomAlphaNumeric(int count) {
			String CARACTERES ="ABCDEFGHIJKLMNOPQRSTVWXYZabcdefghijklmnopqrstvwxyz0123456789";
			StringBuilder builder = new StringBuilder();
			while(count-- !=0) {
				int character =(int) (Math.random()*CARACTERES.length());
				builder.append(CARACTERES.charAt(character));
				
			}
			return builder.toString();
			
		}
	
	
	
	
}
