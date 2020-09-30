package com.cineapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import javax.persistence.Transient;


@Entity
@Table(name= "peliculas")
public class Pelicula {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Auto incremental
	
	
	private int id;
	private String titulo;
	private int duracion;
	private String calificacion;
	private String genero;
	private String imagen = "cinema.png";
	private Date fechaEstreno;
	private String estatus ="Activa";
	//@Transient //Pasa por alto atributi en la persistencia
	@OneToOne
	@JoinColumn(name = "idDetalle")
	private Detalle detalle;
	//atributo pelicula es el declarado en clase Horario
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER) //fetch = FetchType.EAGER Ejecuta consulta para todos los horarios de peliculas
	private List<Horario> lhorarios;


	
	
	
	


	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", calificacion=" + calificacion
				+ ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno + ", estatus="
				+ estatus + ", detalle=" + detalle + "]";
	}


	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	
	public Detalle getDetalle() {
		return detalle;
	}
	
	
	public List<Horario> getLhorarios() {
		return lhorarios;
	}
	public void setLhorarios(List<Horario> lhorarios) {
		this.lhorarios = lhorarios;
	}
	
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
	
	
	
	
	
	
	
	
}
