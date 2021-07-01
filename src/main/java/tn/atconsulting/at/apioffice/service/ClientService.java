package tn.atconsulting.at.apioffice.service;



import java.net.URI;
import java.net.http.HttpClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
        JsonElement root = new JsonParser().parse(response.body());
        String folderID = root.getAsJsonObject().get("id").getAsString();
        System.out.println("value1: "+folderID);
        share( cl, connectionDTO,  folderID);
        
        
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("ERROR AMINNN: "+e.toString());
		}

		return this.clientRepository.save(cl);	
		
    }
 		
		//-------------------------------------------------------------------
	
	public String addPhoto(ConnectionDTO connectionDTO,  byte [] array, String name)  {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("BEFORE SEND IMAGE " + formatter.format(date));
		
		String url_str = "https://graph.microsoft.com/v1.0/me/drive/root:/" + connectionDTO.getIdFolder() + name + ":/content";
   
        String authorizationHeader = "Bearer " + connectionDTO.getBearer_token();
        //System.out.println("hatemm  ------ TOKEN : "+authorizationHeader);‪
		try {

	      //  String fileName = "C:\\Users\\USER\\Pictures\\png_file.png";
	      //  File file = new File(fileName);

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
        
		
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println("AFTER SEND IMAGE " + (date2.getTime() - date.getTime()));
        
        
        return "iamge uploaded successfuly !";

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
	
	public String share(Client cl,ConnectionDTO connectionDTO, String folderID)  {
		//TO DO : Call azure AD WS

        String url_str = "https://graph.microsoft.com/v1.0/me/drive/items/"+folderID+"/invite";
        //String url_str = "https://graph.microsoft.com/v1.0/me/drive/root/children";
        String jsonInputString ="";
        String authorizationHeader ="Bearer " + connectionDTO.getBearer_token();
        

			System.out.println("TOKEN :-"+authorizationHeader);
			 System.out.println("hatemm      ------- aminnnnnn ----(--"+cl.getName());
        jsonInputString =("{\r\n"
        		+ "    \"recipients\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"email\": \""+ cl.getEmail() +"\"\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"message\": \"Here's the file that we're collaborating on.\",\r\n"
        		+ "    \"requireSignIn\": true,\r\n"
        		+ "    \"sendInvitation\": true,\r\n"
        		+ "    \"roles\": [\r\n"
        		+ "        \"write\"\r\n"
        		+ "    ]\r\n"
        		+ "}");
        
        System.out.println("JSON BODY : " + jsonInputString);
		try {
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

        System.out.println("share ok : " + response.body());
        
        
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
