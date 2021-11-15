package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.NatureClient;

import dto.ClientDto;
import dto.NatureClientDto;

public class NatureClientFactory {
	
	public static NatureClient NatureClientDtoToNatureClient(NatureClientDto natureClientDto){
		
		NatureClient natureClient = new NatureClient();
		natureClient.setActif(natureClientDto.getActif());
		natureClient.setDesignation(natureClientDto.getDesignation());
		natureClient.setIdNatureClient(natureClientDto.getIdNatureClient());
		return natureClient;
	}
	
	public static NatureClientDto NatureClientToNatureClientDto(NatureClient natureClient){
		
		NatureClientDto natureClientDto = new NatureClientDto();
		natureClientDto.setActif(natureClient.getActif());
		natureClientDto.setDesignation(natureClient.getDesignation());
		natureClientDto.setIdNatureClient(natureClient.getIdNatureClient());
		return natureClientDto;
	}
	
	public static Collection<NatureClientDto> NatureClientsToNatureClientDtos(Collection<NatureClient> natureClients){
		
		List<NatureClientDto> natureClientDtos = new ArrayList<>();
		for(NatureClient natureClient:natureClients) {
			NatureClientDto natureClientDto= NatureClientToNatureClientDto(natureClient);
			natureClientDtos.add(natureClientDto);
		}
		return natureClientDtos;
		
	}
	
}
