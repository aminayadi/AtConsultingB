package tn.atconsulting.at.apioffice.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.atconsulting.at.apioffice.domain.dto.ConnectionDTO;
import tn.atconsulting.at.apioffice.service.AtConsultingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AtconsultingRestController {
	
	private final     AtConsultingService atconsultingservice;
	
	public AtconsultingRestController(AtConsultingService atconsultingservice) {
		this.atconsultingservice = atconsultingservice;
	}
	
    @PostMapping("/atconsulting")
    public String postMessage() {
        return "Hello from AT Consulting ";
    }
    /*
    @PostMapping("/atconsulting/service")
    public String postService(@RequestBody CustomerDTO customerDTO) {
        return atconsultingservice.firstTest(customerDTO);
    }*/
    
    @PostMapping("/atconsulting/service")
    public  ResponseEntity<String> getService(@RequestBody ConnectionDTO connectionDTO) {
        return atconsultingservice.nodeTest(connectionDTO);
    }

}
