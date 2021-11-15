package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UtilisateurServeur;

public interface ClientServeurRepository extends CrudRepository<UtilisateurServeur,Long> {

}
