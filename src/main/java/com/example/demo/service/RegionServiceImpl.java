package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.RegionRepository;
import com.example.demo.model.Region;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	@Autowired
	RegionRepository regionRepostory;
	
	@Override
	public List<Region> getAllRegion() {
		return (List<Region>) regionRepostory.findAll();
	}

	@Override
	public Region getById(Long idRegion) {
		return regionRepostory.findById(idRegion).get();
	}

	@Override
	public void saveOrUpdate(Region region) {
		regionRepostory.save(region);
		
	}

	@Override
	public void deleteRegion(Long idRegion) {
		regionRepostory.deleteById(idRegion);
		
	}

}
