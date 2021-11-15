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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Serveur")
public class Serveur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServeur;
	
	@Column(name = "adresseIp" ) 
	private String adresseIp;
	
	@Column(name = "domaine" ) 
	private String domaine;
	
	@Column(name = "observation" ) 
	private String observation;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idNatureServeur")
	private NatureServeur natureServeur;
	
	
	@OneToMany(mappedBy = "serveur")
	private Collection<Connexion> connexions;
	
	public Collection<Connexion> getConnexions() {
		return connexions;
	}

	public void setConnexions(Collection<Connexion> connexions) {
		this.connexions = connexions;
	}

	public NatureServeur getNatureServeur() {
		return natureServeur;
	}

	public void setNatureServeur(NatureServeur natureServeur) {
		this.natureServeur = natureServeur;
	}

	public Serveur() {
		
	}

	public Long getIdServeur() {
		return idServeur;
	}

	public void setIdServeur(Long idServeur) {
		this.idServeur = idServeur;
	}

	public String getAdresseIp() {
		return adresseIp;
	}

	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public String toString() {
		return "Serveur [idServeur=" + idServeur + ", adresseIp=" + adresseIp + ", domaine=" + domaine
				+ ", observation=" + observation + ", natureServeur=" + natureServeur + ", connexions=" + connexions
				+ "]";
	}

	
	
	
	
	

}
