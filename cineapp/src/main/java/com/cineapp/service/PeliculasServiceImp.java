package com.cineapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cineapp.model.Pelicula;

@Service
public class PeliculasServiceImp implements IPeliculaService{
	
	private List<Pelicula>lista=null;
	
	public  PeliculasServiceImp() {
		
		System.out.println("Creando Instancia clase Peliculas ServiceImp");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
		
		try {
			
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setCalificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("2020-08-11"));
			pelicula1.setImagen("powerrangers.png");
			
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Matrix Recargado");
			pelicula2.setDuracion(120);
			pelicula2.setCalificacion("A");
			pelicula2.setGenero("Ficcion");
			pelicula2.setFechaEstreno(formatter.parse("02-05-2017"));
			pelicula2.setImagen("matrix.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Advengers, La era de Ultron");
			pelicula3.setDuracion(120);
			pelicula3.setCalificacion("B");
			pelicula3.setGenero("Aventura");
			pelicula3.setFechaEstreno(formatter.parse("2020-08-11"));
			pelicula3.setImagen("eraultron.png");
			pelicula3.setEstatus("inactiva");
			
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Toñitin");
			pelicula4.setDuracion(120);
			pelicula4.setCalificacion("A");
			pelicula4.setGenero("Aventura");
			pelicula4.setFechaEstreno(formatter.parse("02-05-2019"));
//			pelicula4.setImagen("eraultron.png");
			pelicula4.setEstatus("inactiva");
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
		}catch (ParseException e) {
			System.out.println("Error"+ e.getMessage());
		}
	}
	
	
	
	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

}
