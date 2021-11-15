package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.example.demo.model.Region;

import dto.RegionDto;


public class RegionFactory {

	public static Region RegionDtoToRegion(RegionDto regionDto) {
		Region region = new Region();
		region.setIdRegion(regionDto.getIdRegion());
		region.setDesignation(regionDto.getDesignation());
		region.setActif(regionDto.getActif());
		return region;
	}
	
	public static RegionDto lazyRegionToRegionDto(Region region) {
		RegionDto regionDto = new RegionDto();
		regionDto.setIdRegion(region.getIdRegion());
		regionDto.setDesignation(region.getDesignation());
		regionDto.setActif(region.getActif());
		
		return regionDto;
	}
	
	public static RegionDto RegionToRegionDto(Region region) {
		RegionDto regionDto = new RegionDto();
		regionDto.setIdRegion(region.getIdRegion());
		regionDto.setDesignation(region.getDesignation());
		regionDto.setActif(region.getActif());
		regionDto.setClients(ClientFactory.clientsToClientDtos(region.getClients()));
		
		return regionDto;
	}
	
	public static Collection<RegionDto> regionsToRegionDtos(Collection<Region> regions){
		List<RegionDto> regionDtos = new ArrayList<>();
		for(Region region : regions) {
			RegionDto regionDto = lazyRegionToRegionDto(region);
			regionDtos.add(regionDto);
		}
		return regionDtos;
	}
}
