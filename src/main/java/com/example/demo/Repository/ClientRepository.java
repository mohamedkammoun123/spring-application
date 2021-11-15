package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Client;

public interface ClientRepository  extends CrudRepository<Client,Long> {
	
}
