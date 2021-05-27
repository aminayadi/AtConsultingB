package tn.atconsulting.at.apioffice.web.rest;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.atconsulting.at.apioffice.domain.dto.Client;
import tn.atconsulting.at.apioffice.domain.dto.ConnectionDTO;
import tn.atconsulting.at.apioffice.service.AtConsultingService;
import tn.atconsulting.at.apioffice.service.ClientService;





@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AtconsultingRestController {
	
	private final     AtConsultingService atconsultingservice;
	private final     ClientService clientService;

	

	
	@PostMapping("/ajouterClient")
	public Client ajouterClient(@RequestBody Client client) {
		
		return this.clientService.addClient(client);

	}

	@RequestMapping(value = "/DeleteClient/{idC}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable("idC") Long idC){
		return this.clientService.deleteClient(idC);
    }
	
	@GetMapping("/AllClient")
	@ResponseBody
	public List<Client> getWishLists() { 
		List<Client> list = clientService.retrieveAllClient(); 
		return list; 
	} 
	@RequestMapping(value = "/GetOneById/{idC}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("idC") Long idC) {
    	//logger.debug("Invocation de la resource : GET /GetOne/{idB}");
    	Client client = clientService.retrieveClient(idC);

        if (client == null) {
        	//logger.info("Impossible de récupérer le client");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
	
	
	
	
	
	
	public AtconsultingRestController(AtConsultingService atconsultingservice, ClientService clientService) {
		this.atconsultingservice = atconsultingservice;
		this.clientService = clientService ;
	}
	
    
    @PostMapping("/atconsulting/service")
    public  ResponseEntity<String> getService(@RequestBody ConnectionDTO connectionDTO) {
        return atconsultingservice.nodeTest(connectionDTO);
    }
    
    @PostMapping("/atconsulting/subfolder")
    public  ResponseEntity<String> getSubfolder(@RequestBody ConnectionDTO connectionDTO) {
        return atconsultingservice.nodeRoot(connectionDTO);
    }    
    

}
