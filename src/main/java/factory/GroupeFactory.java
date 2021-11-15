package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.Groupe;

import dto.GroupeDto;

public class GroupeFactory {
	
	public static Groupe groupeDtoToGroupe(GroupeDto groupeDto) {
		
		Groupe groupe = new Groupe();
		groupe.setActif(groupeDto.getActif());
		groupe.setAdministration(groupeDto.getAdministration());
		groupe.setDesignation(groupeDto.getDesignation());
		groupe.setIdGroupe(groupeDto.getIdGroupe());
		return groupe;
	}
	
	public static GroupeDto groupeToGroupeDto(Groupe groupe) {
		
		GroupeDto groupeDto = new GroupeDto();
		groupeDto.setIdGroupe(groupe.getIdGroupe());
		groupeDto.setActif(groupe.getActif());
		groupeDto.setAdministration(groupe.getAdministration());
		groupeDto.setDesignation(groupe.getDesignation());
		if(groupe.getGroupePere()!=null) {
		groupeDto.setGroupePere(groupe.getGroupePere().getDesignation());
		}
		return groupeDto;
		
	}
	
	public static Collection<GroupeDto> groupesToGroupeDtos(Collection<Groupe> groupes){
		List<GroupeDto> groupeDtos = new ArrayList<>();
		for(Groupe groupe : groupes) {
			GroupeDto groupeDto = groupeToGroupeDto(groupe);
			groupeDtos.add(groupeDto);
		}
		return groupeDtos;
	}
}
