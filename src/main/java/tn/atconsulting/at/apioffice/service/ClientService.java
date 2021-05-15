package tn.atconsulting.at.apioffice.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.Client;
import tn.atconsulting.at.apioffice.repository.ClientRepository;





@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	
	public Client addClient(Client cl) {
		return this.clientRepository.save(cl);
	}
	
	
	public String deleteClient(Long id) {
		clientRepository.deleteById(id);
		return "ok";
	}

	@Autowired
	public List<Client> retrieveAllClient() {
		// TODO Auto-generated method stub
		List<Client> client=(List<Client>)clientRepository.findAll();
		for (Client cl : client) {
			//L.info("client +++"+cl);
		}
		
		return client;
	}
	/*
	@Autowired
	public Client updateClient(Client client,Long idC) {
		
		Client cl = clientRepository.findById(idC).orElse(null);
		if(cl == null){
			throw new NoResultException();
		}
		cl.setAddress(client.getAddress()); 
		cl.setName(client.getName());
		cl.setType(client.getType());
		
		clientRepository.save(cl);
		return cl ;
	}
	*/
	

}
