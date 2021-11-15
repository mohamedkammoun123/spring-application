package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Region;



public interface RegionService {
	
	public List<Region> getAllRegion();
	
	public Region getById(Long idRegion);
	
	public void saveOrUpdate(Region region);
	
	public void deleteRegion(Long idRegion);
	
}
