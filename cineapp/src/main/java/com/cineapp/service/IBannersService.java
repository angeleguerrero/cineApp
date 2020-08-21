package com.cineapp.service;

import java.util.List;

import com.cineapp.model.Banner;

public interface IBannersService {
	void insertar(Banner banner); 
	List<Banner> buscarTodos();
}
