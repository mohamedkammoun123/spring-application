package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeAcces")
public class TypeAcces implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeAcces;
	
	@Column(name = "designation" ) 
	private String designation;

	public Long getIdTypeAcces() {
		return idTypeAcces;
	}

	public void setIdtypeAcces(Long idtypeAcces) {
		this.idTypeAcces = idTypeAcces;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "typeAcces [idTypeAcces=" + idTypeAcces + ", designation=" + designation + "]";
	}
	
	public TypeAcces() {
		
	}
	
	
}
