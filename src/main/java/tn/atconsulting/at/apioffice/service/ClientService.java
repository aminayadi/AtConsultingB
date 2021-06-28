package tn.atconsulting.at.apioffice.service;


import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import io.undertow.util.FileUtils;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import tn.atconsulting.at.apioffice.domain.dto.Client;
import tn.atconsulting.at.apioffice.domain.dto.ConnectionDTO;
import tn.atconsulting.at.apioffice.repository.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	ConnectionDTO connectionDTO;
	

	public Client addClient(Client cl,ConnectionDTO connectionDTO)  {
		String url_str = "https://graph.microsoft.com/v1.0/me/drive/root/children";
        String jsonInputString ="";
        String authorizationHeader = "Bearer " + connectionDTO.getBearer_token();
        System.out.println("hatemm  ------ TOKEN : "+authorizationHeader);
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

        System.out.println("NEJJJJJJJJHET : " + response.body());
        
        
        
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("ERROR AMINNN: "+e.toString());
		}

		return this.clientRepository.save(cl);	
		
    }
 		
		//-------------------------------------------------------------------
	
	public String addPhoto(ConnectionDTO connectionDTO,  byte [] array)  {
		
		
		String url_str = "https://graph.microsoft.com/v1.0/me/drive/root:/baaaa.png:/content";
   
        String authorizationHeader = "Bearer " + connectionDTO.getBearer_token();
        //System.out.println("hatemm  ------ TOKEN : "+authorizationHeader);‪
		try {

	        String fileName = "C:\\Users\\USER\\Pictures\\png_file.png";
	        File file = new File(fileName);

	       // byte [] array = Files.readAllBytes(file.toPath());
	        System.out.println(array.toString());
        HttpClient photo = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .PUT(HttpRequest.BodyPublishers.ofByteArray(array))
                .header("Authorization", authorizationHeader)
                .header("Content-Type", "image/png")
                .build()
                ;
        

        
        HttpResponse<String> response = photo.send(request,
                HttpResponse.BodyHandlers.ofString());
        return "aycha fatma fatma";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("ERROR AMINNN: "+e.toString());
		}

		return "NKKK";
		
    }
 		
	
	
	//----------------------------------------------------------------
 		
 		
	
	
	
	public String deleteClient(Long id) {
		clientRepository.deleteById(id);
		return "ok";
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	public String share(Client cl,ConnectionDTO connectionDTO)  {
		//TO DO : Call azure AD WS

        String url_str = "https://graph.microsoft.com/v1.0/me/drive/items/CB15C23159F83DFC!118/invite";
        //String url_str = "https://graph.microsoft.com/v1.0/me/drive/root/children";
        String jsonInputString ="";
        String authorizationHeader ="Bearer " + connectionDTO.getBearer_token();
        
		try {
			System.out.println("TOKEN :-"+authorizationHeader);
			 System.out.println("hatemm      ------- aminnnnnn ----(--"+cl.getName());
        jsonInputString =("{\r\n"
        		+ "    \"recipients\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"email\": \"amin.ayadi@esprit.tn\"\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"message\": \"Here's the file that we're collaborating on.\",\r\n"
        		+ "    \"requireSignIn\": false,\r\n"
        		+ "    \"sendInvitation\": true,\r\n"
        		+ "    \"roles\": [\r\n"
        		+ "        \"write\"\r\n"
        		+ "    ]\r\n"
        		+ "}");
       
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .header("Authorization", authorizationHeader)
                .header("Content-Type", "application/json; charset=UTF-8")
                .build()
                ;

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        
        
        return "fatma fatma fatma";
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("ERROR AMINNN: "+e.toString());
		}
		return "fatma fatma fatma";
		
	}
	
	

	////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	

	@Autowired
	public List<Client> retrieveAllClient() {
		// TODO Auto-generated method stub
		List<Client> client=(List<Client>)clientRepository.findAll();
		for (Client cl : client) {
			//L.info("client +++"+cl);
		}
		
		return client;
	}


	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		Client u= clientRepository.findById(id).orElse(null);;
		//L.info("retrive bank by id ++++:"+u);
		return u;
	}
	

}
