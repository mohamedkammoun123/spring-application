package dto;

import java.util.Collection;

import com.example.demo.model.Connexion;

public class ServeurDto {
	
	private Long idServeur;
	
	private String adresseIp;
	
	private String domaine;
	
	private String observation;
	
	private String natureServeur;
	
	private Collection<Connexion> connexions;

	public String getNatureServeur() {
		return natureServeur;
	}

	public void setNatureServeur(String natureServeur) {
		this.natureServeur = natureServeur;
	}

	public Collection<Connexion> getConnexions() {
		return connexions;
	}

	public void setConnexions(Collection<Connexion> connexions) {
		this.connexions = connexions;
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
	
}
