package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import com.example.demo.model.Utilisateur;

import dto.UtilisateurDto;

public interface UtilisateurService {
	
	public Collection<UtilisateurDto> getAllUtilisateur();
	
	public UtilisateurDto getById(Long id);
	
	public void saveOrUpdate(Utilisateur utilisateur);
	
	public void deleteUtilisateur(Long id);
}
