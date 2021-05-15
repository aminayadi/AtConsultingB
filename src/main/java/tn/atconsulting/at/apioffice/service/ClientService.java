package tn.atconsulting.at.apioffice.service;

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

}
