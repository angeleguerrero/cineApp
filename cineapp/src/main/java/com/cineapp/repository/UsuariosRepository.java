package com.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineapp.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
