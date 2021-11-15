package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

}
