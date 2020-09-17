package com.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineapp.model.Detalle;
@Repository
public interface DetallesRepository extends JpaRepository<Detalle, Integer> {

}
