package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.Serveur;

import dto.ServeurDto;

public class ServeurFactory {
	
	public static Serveur ServeurDtoToServeur(ServeurDto serveurDto) {
		Serveur serveur=new Serveur();
		serveur.setAdresseIp(serveurDto.getAdresseIp());
		serveur.setIdServeur(serveurDto.getIdServeur());
		serveur.setDomaine(serveurDto.getDomaine());
		serveur.setConnexions(serveurDto.getConnexions());
		return serveur;
	}
	
	public static ServeurDto ServeurToServeurDto(Serveur serveur) {
		ServeurDto serveurDto = new ServeurDto();
		serveurDto.setAdresseIp(serveur.getAdresseIp());
		serveurDto.setDomaine(serveur.getDomaine());
		serveurDto.setIdServeur(serveur.getIdServeur());
		if(serveur.getNatureServeur()!=null) {
		serveurDto.setNatureServeur(serveur.getNatureServeur().getDesignation());
		}
		serveurDto.setObservation(serveur.getObservation());
		serveurDto.setConnexions(serveur.getConnexions());
		return serveurDto;
	}
	
	public static Collection<ServeurDto> ServeursToServeurDtos(Collection<Serveur> serveurs){
		List<ServeurDto> serveurDtos = new ArrayList<>();
		for(Serveur serveur : serveurs) {
			ServeurDto serveurDto = ServeurToServeurDto(serveur);
			serveurDtos.add(serveurDto);
		}
		return serveurDtos;
	}
	
}
