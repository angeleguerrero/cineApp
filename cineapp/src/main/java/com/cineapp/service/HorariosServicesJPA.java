package com.cineapp.service;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cineapp.model.Horario;
import com.cineapp.repository.HorarioRepository;

@Service
public class HorariosServicesJPA implements IHorariosService {
	@Autowired
	private HorarioRepository hrepo;
	
	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		
//				Objeto Pelicula+Id Pelicula
	
		
		
		return hrepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

}
