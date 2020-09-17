package com.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineapp.model.Horario;
@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}
