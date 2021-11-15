package com.example.demo.model;

import java.io.Serializable;
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

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom" ) 
	private String nom;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idRegion")
	private Region region;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idNatureClient")
	private NatureClient natureClient;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idServeur")
	private Collection<Serveur> serveurs;
	
	public Collection<Serveur> getServeurs() {
		return serveurs;
	}



	public void setServeurs(Collection<Serveur> serveurs) {
		this.serveurs = serveurs;
	}



	public NatureClient getNatureClient() {
		return natureClient;
	}



	public void setNatureClient(NatureClient natureClient) {
		this.natureClient = natureClient;
	}



	public Region getRegion() {
		return region;
	}



	public void setRegion(Region region) {
		this.region = region;
	}



	public Client() {
		
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", region=" + region + ", natureClient=" + natureClient
				+ ", serveurs=" + serveurs + "]";
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	

	
	

	
	
	
}
