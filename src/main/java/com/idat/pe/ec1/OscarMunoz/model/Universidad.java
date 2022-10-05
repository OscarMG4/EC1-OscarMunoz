package com.idat.pe.ec1.OscarMunoz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "universidades")
public class Universidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	
	@Column(name="universidad", nullable = false)
	private String universidad;
	
	@OneToOne
	private MallaCurricular mallaCurricular;
	
	
	public Integer getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	public MallaCurricular getMallaCurricular() {
		return mallaCurricular;
	}
	public void setMallaCurricular(MallaCurricular mallaCurricular) {
		this.mallaCurricular = mallaCurricular;
	}

}
