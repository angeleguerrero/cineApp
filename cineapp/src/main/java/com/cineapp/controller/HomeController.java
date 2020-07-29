package com.cineapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cineapp.model.Pelicula;



@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome( ) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashBoardIndex(Model model) {
		List<Pelicula>peliculas = getLista();
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
//		peliculas.add("Advengers");
//		peliculas.add("Matrix");
		model.addAttribute("peliculas", peliculas);
		
		
		
		return"home";
	}
	
	
	private List<Pelicula>getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
		List<Pelicula>lista=null;
		try {
			
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setCalificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2018"));
			
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Matrix Recargado");
			pelicula2.setDuracion(120);
			pelicula2.setCalificacion("B");
			pelicula2.setGenero("Ficcion");
			pelicula2.setFechaEstreno(formatter.parse("02-05-2017"));
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Advengers, La era de Ultron");
			pelicula3.setDuracion(120);
			pelicula3.setCalificacion("B");
			pelicula3.setGenero("Aventura");
			pelicula3.setFechaEstreno(formatter.parse("02-05-2019"));
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			return lista;
			
		}catch (ParseException e) {
			System.out.println("Error"+ e.getMessage());
			return null;
		}
		
	}
	
	
	
	@RequestMapping(value = "/detail")
	public String mostrarDetalles(Model model) {
		String tituliPelicula="Rapido y Furioso";
		int duracion = 136;
		double precioEntrada =50.00;
		
		model.addAttribute("titulo", tituliPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio" , precioEntrada);
		
		return "detalle";
	}
	
	
}
