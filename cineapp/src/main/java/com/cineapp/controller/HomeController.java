package com.cineapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineapp.model.Pelicula;
import com.cineapp.util.Utileria;



@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome( ) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashBoardIndex(Model model) {
		List<String> listafechas = Utileria.getNextDays(9);
//		System.out.println(listafechas);
		List<Pelicula>peliculas = getLista();
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
//		peliculas.add("Advengers");
//		peliculas.add("Matrix");
		model.addAttribute("fechas", listafechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
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
			pelicula3.setFechaEstreno(formatter.parse("02-05-2019"));
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
			return lista;
			
		}catch (ParseException e) {
			System.out.println("Error"+ e.getMessage());
			return null;
		}
		
	}
	
	
	
//	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public String mostrarDetalles(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
	public String mostrarDetalles(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		System.out.println("BURCAR ID PELICULA: "+idPelicula);
		System.out.println("PARA FECHA DE PELICULA: "+fecha);
		
//		String tituliPelicula="Rapido y Furioso";
//		int duracion = 136;
//		double precioEntrada =50.00;
//		model.addAttribute("titulo", tituliPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio" , precioEntrada);
		
		return "detalle";
	}
	
	
}
