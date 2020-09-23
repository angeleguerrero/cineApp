package com.cineapp.service;

import java.util.Date;
import java.util.List;

import com.cineapp.model.Horario;

public interface IHorariosService {
List<Horario>buscarPorIdPelicula(int idPelicula, Date fecha);
	
	
	
	
}
