package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.TypeAcces;

import dto.TypeAccesDto;

public class TypeAccesFactory {
	
	public static TypeAcces typeAccesDtoToTypeAcces(TypeAccesDto typeAccesDto) {
		TypeAcces typeAcces = new TypeAcces();
		typeAcces.setIdtypeAcces(typeAccesDto.getIdTypeAcces());
		typeAcces.setDesignation(typeAccesDto.getDesignation());
		return typeAcces;
	}
	
	public static TypeAccesDto typeAccesToTypeAccesDto(TypeAcces typeAcces) {
		TypeAccesDto typeAccesDto = new TypeAccesDto();
		typeAccesDto.setDesignation(typeAcces.getDesignation());
		typeAccesDto.setIdTypeAcces(typeAcces.getIdTypeAcces());
		return typeAccesDto;
	}
	
	public static Collection<TypeAccesDto> typeAccessToTypeAccesDtos(Collection<TypeAcces> typeAccess){
		List<TypeAccesDto> typeAccesDtos = new ArrayList<>();
		for(TypeAcces typeAcces : typeAccess) {
			TypeAccesDto typeAccesDto = typeAccesToTypeAccesDto(typeAcces);
			typeAccesDtos.add(typeAccesDto);
		}
		return typeAccesDtos;
	}
}
