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

@Entity
@Table(name = "Natureclient")
public class NatureClient implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNatureClient;
	
	@Column(name = "designation" ) 
	private String designation;
	
	@Column(name = "actif" )
	private String actif;
	
	//@OneToMany(mappedBy = "natureClient")
	//private Collection<Client> clients;

	//public Collection<Client> getClients() {
		//return clients;
	//}

	//public void setClients(Collection<Client> clients) {
		//this.clients = clients;
	//}

	public NatureClient() {
		
	}

	public Long getIdNatureClient() {
		return idNatureClient;
	}

	public void setIdNatureClient(Long idNatureClient) {
		this.idNatureClient = idNatureClient;
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
		return "NatureClient [idNatureClient=" + idNatureClient + ", designation=" + designation + ", actif=" + actif
				+ "]";
	}
	
	
	
	
}
