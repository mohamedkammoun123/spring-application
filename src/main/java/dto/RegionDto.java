package dto;

import java.util.Collection;
import java.util.List;



public class RegionDto {
	
	private Long idRegion;
	
	private String designation;
	
	private String actif;
	
	Collection<ClientDto> clients;

	public Collection<ClientDto> getClients() {
		return clients;
	}

	public void setClients(Collection<ClientDto> clients) {
		this.clients = clients;
	}

	public Long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Long idRegion) {
		this.idRegion = idRegion;
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
	
	
}
