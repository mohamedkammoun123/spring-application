package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {

}
