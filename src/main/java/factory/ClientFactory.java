package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.Client;

import dto.ClientDto;

public class ClientFactory {
	
	public static Client clientDtoToClient(ClientDto clientDto) {
		Client client = new Client();
		client.setId(clientDto.getId());
		client.setNom(clientDto.getNom());
		return client;
	}
	
	public static ClientDto clientToClientDto(Client client) {
		ClientDto clientDto = new ClientDto();
		clientDto.setId(client.getId());
		clientDto.setNom(client.getNom());
		//if(client.getRegion()!=null) {
		//clientDto.setRegion(client.getRegion().getDesignation());}
		return clientDto;
	}
	
	public static Collection<ClientDto> clientsToClientDtos(Collection<Client> clients){
		List<ClientDto> clientDtos = new ArrayList<>();
		for(Client client : clients) {
			ClientDto clientDto = clientToClientDto(client);
			clientDtos.add(clientDto);
		}
		return clientDtos;
	}
}
