package com.cineapp.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cineapp.model.Pelicula;
import com.cineapp.service.IPeliculaService;
import com.cineapp.service.IDetalleService;
import com.cineapp.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	@Autowired
	private IDetalleService serviceDetalles;
	
	@Autowired
	private IPeliculaService servicePelicula;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula>lista = servicePelicula.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "form/listPeliculas";
	}
	
	
 
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		model.addAttribute("generos", servicePelicula.buscarGeneros());
		return "form/formPeliculas";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula , BindingResult result,RedirectAttributes atributes, 
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest  request ) {
		
		
		if (result.hasErrors()) {
			System.out.println("Exieten errores");
			return "form/formPeliculas";
			}
	
//		for (ObjectError error : result.getAllErrors()) {
//			System.out.println(error.getDefaultMessage());
//		}
		
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart,request);
			pelicula.setImagen(nombreImagen);
			}
		
		System.out.println("Salvando OBJ Pelicula > " + pelicula);
		System.out.println("Elementos en la lista Antes de insercion OBJ Detalles" + servicePelicula.buscarTodas().size() +"***");
		System.out.println("Antes insertar"+pelicula.getDetalle());
		serviceDetalles.insertar(pelicula.getDetalle());
		servicePelicula.insertar(pelicula);
		System.out.println("despues  insertar OBJ Detalles"+pelicula.getDetalle());
		System.out.println("Elementos en la lista despues de la insercion" + servicePelicula.buscarTodas().size());
		
		atributes.addFlashAttribute("mensaje" , "Registro guardado correctamente");
//		return "form/formPeliculas";
		return "redirect:/peliculas/index";
		
	}
	
	
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false) );
	}
	
}
