package com.example.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "connexion")
public class Connexion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConnexion;
	
	@Column(name = "login" ) 
	private String login;
	
	@Column(name = "motPasse" ) 
	private String motPasse;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idTypeAcces")
	private TypeAcces typeAcces;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idServeur")
	private Serveur serveur;
	
	public TypeAcces getTypeAcces() {
		return typeAcces;
	}

	public Serveur getServeur() {
		return serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}

	public void setTypeAcces(TypeAcces typeAcces) {
		this.typeAcces = typeAcces;
	}

	public Long getIdConnexion() {
		return idConnexion;
	}

	public void setIdConnexion(Long idConnexion) {
		this.idConnexion = idConnexion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	public Connexion() {
		
	}

	@Override
	public String toString() {
		return "Connexion [idConnexion=" + idConnexion + ", login=" + login + ", motPasse=" + motPasse + ", typeAcces="
				+ typeAcces + "]";
	}

	
	
	
}
