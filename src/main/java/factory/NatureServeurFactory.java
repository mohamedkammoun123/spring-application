package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.NatureServeur;

import dto.NatureServeurDto;

public class NatureServeurFactory {
	
	public static NatureServeur natureServeurDtoToNatureServeur(NatureServeurDto natureServeurDto) {
		NatureServeur natureServeur = new NatureServeur();
		natureServeur.setActif(natureServeurDto.getActif());
		natureServeur.setDesignation(natureServeurDto.getDesignation());
		natureServeur.setIdNatureServeur(natureServeur.getIdNatureServeur());
		return natureServeur;
	}
	
	public static NatureServeurDto natureServeurToNatureServeurDto(NatureServeur natureServeur) {
		NatureServeurDto natureServeurDto = new NatureServeurDto();
		natureServeurDto.setActif(natureServeur.getActif());
		natureServeurDto.setDesignation(natureServeur.getDesignation());
		natureServeurDto.setIdNatureServeur(natureServeur.getIdNatureServeur());
		return natureServeurDto;
	}
	 public static Collection<NatureServeurDto> natureServeursToNatureServeurDtos(Collection<NatureServeur> natureServeurs){
		 List<NatureServeurDto> natureServeurDtos = new ArrayList<>();
		 for(NatureServeur natureServeur:natureServeurs) {
			 NatureServeurDto natureServeurDto=natureServeurToNatureServeurDto(natureServeur);
			 natureServeurDtos.add(natureServeurDto);
		 }
		 return natureServeurDtos;
	 }
}
