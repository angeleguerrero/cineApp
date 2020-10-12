package com.cineapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarioperfil")
public class Usuarioperfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private int id;
private String username;
private String perfil;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPerfil() {
	return perfil;
}
public void setPerfil(String perfil) {
	this.perfil = perfil;
}
@Override
public String toString() {
	return "Usuarioperfil [id=" + id + ", username=" + username + ", perfil=" + perfil + "]";
}







}
