package com.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cineapp.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

}
