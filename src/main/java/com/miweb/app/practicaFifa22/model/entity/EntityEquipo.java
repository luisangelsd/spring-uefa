package com.miweb.app.practicaFifa22.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "equipos")
public class EntityEquipo implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String equipo;
	
	@NotEmpty
	private String pais;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_de_registro")
	private Date fechaDeRegistro;
	
	
	@PrePersist
	private void prePersistFechaRegistro() {
		fechaDeRegistro=new Date();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(Date fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
