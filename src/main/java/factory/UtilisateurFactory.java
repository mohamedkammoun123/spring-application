package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.Utilisateur;

import dto.UtilisateurDto;

public class UtilisateurFactory {
	
	public static Utilisateur UtilisateurDtoToUtilisateur(UtilisateurDto utilisateurDto) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(utilisateurDto.getIdUtilisateur());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setLogin(utilisateurDto.getLogin());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		return utilisateur;
	}
	
	public static UtilisateurDto UtilisateurToUtilisateurDto(Utilisateur utilisateur) {
		UtilisateurDto utilisateurDto = new UtilisateurDto();
		utilisateurDto.setIdUtilisateur(utilisateur.getIdUtilisateur());
		utilisateurDto.setNom(utilisateur.getNom());
		utilisateurDto.setLogin(utilisateur.getLogin());
		utilisateurDto.setEmail(utilisateur.getEmail());
		utilisateurDto.setPrenom(utilisateurDto.getPrenom());
		//if(Utilisateur.getRegion()!=null) {
		//UtilisateurDto.setRegion(Utilisateur.getRegion().getDesignation());}
		return utilisateurDto;
	}
	
	public static Collection<UtilisateurDto> UtilisateursToUtilisateurDtos(Collection<Utilisateur> utilisateurs){
		List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
		for(Utilisateur utilisateur : utilisateurs) {
			UtilisateurDto utilisateurDto = UtilisateurToUtilisateurDto(utilisateur);
			utilisateurDtos.add(utilisateurDto);
		}
		return utilisateurDtos;
	}
}
