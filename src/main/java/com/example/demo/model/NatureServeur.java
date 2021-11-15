package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "NatureServeur")
public class NatureServeur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNatureServeur;
	
	@Column(name = "designation" ) 
	private String designation;
	
	@Column(name = "actif" )
	private String actif;
	
	public NatureServeur() {
		
	}

	public Long getIdNatureServeur() {
		return idNatureServeur;
	}

	public void setIdNatureServeur(Long idNatureServeur) {
		this.idNatureServeur = idNatureServeur;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getActif() {
		return actif;
	}

	public void setActif(String actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "NatureServeur [idNatureServeur=" + idNatureServeur + ", designation=" + designation + ", actif=" + actif
				+ "]";
	}
    
	
	
	
}
