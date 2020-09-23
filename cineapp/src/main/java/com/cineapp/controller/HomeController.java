package com.cineapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineapp.model.Horario;
import com.cineapp.model.Pelicula;
import com.cineapp.service.IBannersService;
import com.cineapp.service.IHorariosService;
import com.cineapp.service.IPeliculaService;
import com.cineapp.util.Utileria;


@Controller
public class HomeController {
	@Autowired	
	private IPeliculaService ServicePelicula;
	
	@Autowired
	private IBannersService serviceBanners; // Ejercicio : Solucion
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome( ) {
		return "home";
	}

	@RequestMapping(value = "/buscar", method =RequestMethod.POST)
	public String buscarDate(@RequestParam("fecha") String fecha, Model model) {
		List<String> listafechas = Utileria.getNextDays(9);
		List<Pelicula>peliculas = ServicePelicula.buscarTodas();
		model.addAttribute("fechas", listafechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion
		System.out.println("Peliculas paa la fecha" + fecha);
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashBoardIndex(Model model) {
		List<String> listafechas = Utileria.getNextDays(9);
		List<Pelicula>peliculas = ServicePelicula.buscarTodas(); 
		model.addAttribute("fechas", listafechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);	
		model.addAttribute("bannershome", serviceBanners.buscarTodos()); // Ejercicio : Solucion
		return"home";
	}
	
	
	
	
	
//	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public String mostrarDetalles(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
	public String mostrarDetalles(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") Date fecha) {
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		System.out.println("BURCAR ID PELICULA: "+idPelicula);
		
		System.out.println("PARA FECHA DE PELICULA: "+fecha);
		model.addAttribute("pelicula", ServicePelicula.buscarPorId(idPelicula));

		
//		String tituliPelicula="Rapido y Furioso";
//		int duracion = 136;
//		double precioEntrada =50.00;
//		model.addAttribute("titulo", tituliPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio" , precioEntrada);
		
		return "detalle";
	}
	
	
	
	
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false) );
	}
	
	
	
}
