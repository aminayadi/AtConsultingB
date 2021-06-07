package tn.atconsulting.at.apioffice.service;


import java.net.HttpURLConnection;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import tn.atconsulting.at.apioffice.domain.dto.Client;
import tn.atconsulting.at.apioffice.domain.dto.ConnectionDTO;
import tn.atconsulting.at.apioffice.repository.ClientRepository;
import tn.atconsulting.at.apioffice.domain.dto.Notification;






@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	ConnectionDTO connectionDTO;
	
	@SuppressWarnings("deprecation")
	public Client addClient(Client cl,ConnectionDTO connectionDTO)  {
		//TO DO : Call azure AD WS
		HttpURLConnection con = null;
        String url_str = "https://graph.microsoft.com/v1.0/me/drive/root/children";
        String jsonInputString ="";
        String authorizationHeader = "Bearer " + connectionDTO.getBearer_token();
        URL url;
		try {
			 System.out.println("hatemm      ------- aminnnnnn ----(--"+cl.getName());
        jsonInputString =("{\r\n  \"name\": \""+cl.getName() + "\",\r\n  \"folder\": { },\r\n  \"@microsoft.graph.conflictBehavior\": \"rename\"\r\n}");
       
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .header("Authorization", authorizationHeader)
                .header("Content-Type", "application/json")
                .build()
                ;

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        
        
        
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("ERROR AMINNN: "+e.toString());
		}

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
	

	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		Client u= clientRepository.findById(id).orElse(null);;
		//L.info("retrive bank by id ++++:"+u);
		return u;
	}
	

}
