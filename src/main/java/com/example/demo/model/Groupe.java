package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Groupe")
public class Groupe implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGroupe;
	
	@Column(name = "designation" ) 
	private String designation;
	
	@Column(name = "administration" ) 
	private String administration;
	
	@Column(name = "actif" ) 
	private Boolean actif;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idGroupe")
	@JsonBackReference
	private Groupe groupePere;
	
	public Groupe getGroupePere() {
		return groupePere;
	}

	public void setGroupePere(Groupe groupePere) {
		this.groupePere = groupePere;
	}

	public Groupe() {
		
	}

	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAdministration() {
		return administration;
	}

	public void setAdministration(String administration) {
		this.administration = administration;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", designation=" + designation + ", administration=" + administration
				+ ", actif=" + actif + ", groupePere=" + groupePere + "]";
	}
	
	
}
