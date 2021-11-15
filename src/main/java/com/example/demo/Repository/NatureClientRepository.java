package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.NatureClient;

public interface NatureClientRepository extends CrudRepository<NatureClient,Long> {

}
