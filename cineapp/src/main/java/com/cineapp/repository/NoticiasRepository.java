package com.cineapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cineapp.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository <Noticia, Integer> {

//	Buscarpor
	List<Noticia> findBy();
//	BuscarporEstatus
	List<Noticia> findByEstatus(String estatus);
//	Buscarporfecha
	List<Noticia> findByFecha(Date fecha);
	
//	Buscarporfechayestatus Se deben cumplir las dos condiciones
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
//	Buscarporfecha_o_estatus Se cumple una u otra condiciones
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	
//	Buscarporfecha_between_estatus Se cumple una u otra condiciones
	
	List<Noticia>findByFechaBetween(Date fechaini, Date fechafinal);
	
}
