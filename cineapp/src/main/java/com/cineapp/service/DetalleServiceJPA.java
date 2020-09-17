package com.cineapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineapp.model.Detalle;
import com.cineapp.repository.DetallesRepository;
@Service
public class DetalleServiceJPA implements IDetalleService {
	@Autowired
	private DetallesRepository detallesRepo;
	
	@Override
	public void insertar(Detalle detalle) {
	detallesRepo.save(detalle);	
		
	}

}
