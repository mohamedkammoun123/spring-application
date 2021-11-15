package dto;

public class GroupeDto {
	
	private Long idGroupe;
	
	private String designation;
	
	private String administration;
	
	private String GroupePere;
	
	private Boolean actif;

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
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

	public String getGroupePere() {
		return GroupePere;
	}

	public void setGroupePere(String groupePere) {
		GroupePere = groupePere;
	}
	
}
