package com.example.demo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Region;
import com.example.demo.service.RegionService;
import com.google.common.base.Preconditions;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class RegionController {
	
	@Autowired
	RegionService regionService;
	
	
	@PostMapping("/region")
	public Region saveRegion(@RequestBody Region region,BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
		if(region.getIdRegion() != null) {
			System.out.println("hello");
			bindingResult.addError(new FieldError("Region","code","Post is not allowed with a code"));
			System.out.println(region.getIdRegion());
			throw new MethodArgumentNotValidException(null, bindingResult);
			
		}
		System.out.println(region.getIdRegion());
		regionService.saveOrUpdate(region);
		return region;
	}
	
	@GetMapping("/region")
	public List<Region> listRegion(){
		return regionService.getAllRegion();
	}
	
	@GetMapping("/region/{id}")
	public Region getById(@PathVariable (value = "id") Long id) {
		
		return regionService.getById(id);
	}
	
	@DeleteMapping("/region/{id}")
	public String DeleteRegion(@PathVariable (value = "id") Long id) {
		regionService.deleteRegion(id);
		return "delete succes idRegion = " + id.toString();
	}
}
