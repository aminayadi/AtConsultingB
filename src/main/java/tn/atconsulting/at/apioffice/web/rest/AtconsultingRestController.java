package tn.atconsulting.at.apioffice.web.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
