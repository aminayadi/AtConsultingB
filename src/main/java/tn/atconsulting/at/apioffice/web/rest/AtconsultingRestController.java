package tn.atconsulting.at.apioffice.web.rest;


import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.atconsulting.at.apioffice.domain.dto.Client;
import tn.atconsulting.at.apioffice.domain.dto.Notification;
import tn.atconsulting.at.apioffice.domain.dto.Role;
import tn.atconsulting.at.apioffice.domain.dto.ConnectionDTO;
import tn.atconsulting.at.apioffice.domain.dto.DPhoto;
import tn.atconsulting.at.apioffice.domain.dto.Event;

import tn.atconsulting.at.apioffice.domain.dto.Holder;
import tn.atconsulting.at.apioffice.domain.dto.Log;

import tn.atconsulting.at.apioffice.domain.dto.News;
import tn.atconsulting.at.apioffice.domain.dto.Tags;
import tn.atconsulting.at.apioffice.service.AtConsultingService;
import tn.atconsulting.at.apioffice.service.ClientService;
import tn.atconsulting.at.apioffice.service.EventService;
import tn.atconsulting.at.apioffice.service.LogService;
import tn.atconsulting.at.apioffice.service.NewsService;
import tn.atconsulting.at.apioffice.service.NotificationService;
import tn.atconsulting.at.apioffice.service.TagsService;
import tn.atconsulting.at.apioffice.service.RoleService;





@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AtconsultingRestController {
	
	private final     AtConsultingService atconsultingservice;
	private final     ClientService clientService;
	private final     NotificationService notificationService;
	private final     LogService logService;
	private final     EventService eventService;
	private final     NewsService newsService;
	private final     TagsService tagsService;
	private final     RoleService roleService;
	
	@PostMapping("/ajouterClient")
	public Client ajouterClient(@RequestBody Holder holder)  {
		Client client = holder.getClient();
		ConnectionDTO connectionDTO = holder.getConnection();
		return this.clientService.addClient(client, connectionDTO);

	}
	
	@PutMapping("/ajouterPhoto")
	public String ajouterPhoto(@RequestBody  DPhoto dPhoto)  {
		ConnectionDTO connectionDTO = dPhoto.getConnection();
		
		return this.clientService.addPhoto(connectionDTO, dPhoto.getPhoto(), dPhoto.getpName());

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
	
	
	
	
	
	
	public AtconsultingRestController(AtConsultingService atconsultingservice, ClientService clientService,NotificationService notificationservice,LogService logService,EventService eventService,NewsService newsService,TagsService tagsService,RoleService roleService) {
		this.atconsultingservice = atconsultingservice;
		this.clientService = clientService ;
		this.notificationService=notificationservice;
		this.logService =logService;
		this.eventService = eventService;
		this.newsService =newsService;
		this.tagsService =tagsService;
		this.roleService=roleService;
		
		
		
	}
	
    
    @PostMapping("/atconsulting/service")
    public  ResponseEntity<String> getService(@RequestBody ConnectionDTO connectionDTO) {
        return atconsultingservice.nodeTest(connectionDTO);
    }
    
    @PostMapping("/atconsulting/subfolder")
    public  ResponseEntity<String> getSubfolder(@RequestBody ConnectionDTO connectionDTO) {
        return atconsultingservice.nodeRoot(connectionDTO);
    }    
    //----------------------Notification----------------------------
    
    
    
    @PostMapping("/ajouterNotification")
	public Notification ajouterNotification(@RequestBody Notification notification)  {
		
		return this.notificationService.addNotification(notification);

	}
    
    @GetMapping("/AllNotification")
	@ResponseBody
	public List<Notification> getWisLists() { 
		List<Notification> list = notificationService.retrieveAllNotification(); 
		return list; 
	} 
    @RequestMapping(value = "/DeleteNotification/{idN}", method = RequestMethod.DELETE)
    public String deleteNotification(@PathVariable("idN") Long idN){
		return this.notificationService.deleteNotification(idN);
    }
    
    
    
    
//----------------------Tags----------------------------
    
    
    
    @PostMapping("/ajouterTags")
	public Tags ajouterTags(@RequestBody Tags tags)  {
    
		return this.tagsService.addTags(tags);

	}
    
    @GetMapping("/AllTags")
	@ResponseBody
	public List<Tags> getTagsLists() { 
		List<Tags> list = tagsService.retrieveAllTags(); 
		return list; 
	} 
    @RequestMapping(value = "/DeleteTags/{idTags}", method = RequestMethod.DELETE)
    public String deleteTags(@PathVariable("idTags") Long idTags){
		return this.tagsService.deleteTags(idTags);
    }
    
    
    
    
//----------------------Log----------------------------
    
    
    
    @PostMapping("/ajouterLog")
	public Log ajouterLog(@RequestBody Log log)  {
    	
		return this.logService.addLog(log);

	}
    
    @GetMapping("/AllLog")
	@ResponseBody
	public List<Log> getLogLists() { 
		List<Log> list = logService.retrieveAllLog(); 
		return list; 
	} 
    @RequestMapping(value = "/DeleteLog/{idN}", method = RequestMethod.DELETE)
    public String deleteLog(@PathVariable("idLog") Long idLog){
		return this.logService.deleteLog(idLog);
    }
    
    
    
    
//----------------------Event----------------------------
    
    
    
    @PostMapping("/ajouterEvent")
	public Event ajouterEvent(@RequestBody Event event)  {
    	
		return this.eventService.addEvent(event);

	}
    
    @GetMapping("/AllEvent")
	@ResponseBody
	public List<Event> getEventLists() { 
		List<Event> list = eventService.retrieveAllEvent(); 
		return list; 
	} 
    @RequestMapping(value = "/DeleteEvent/{idEvent}", method = RequestMethod.DELETE)
    public String deleteEvent(@PathVariable("idEvent") Long idEvent){
		return this.eventService.deleteEvent(idEvent);
    }
    
    
    
    
//----------------------News----------------------------
    
    
    
    @PostMapping("/ajouterNews")
  	public News ajouterNews(@RequestBody News news)  {
      	
  		return this.newsService.addNews(news);

  	}
      
    @GetMapping("/AllNews")
	@ResponseBody
	public List<News> getNewsLists() { 
		List<News> list = newsService.retrieveAllNews(); 
		return list; 
	} 
    @RequestMapping(value = "/DeleteNews/{idNews}", method = RequestMethod.DELETE)
    public String deleteNews(@PathVariable("idNews") Long idNews){
		return this.newsService.deleteNews(idNews);
    }
    
    //------------Role----------------------
    @PostMapping("/ajouterRole")
  	public Role ajouterRole(@RequestBody Role role)  {
      	
  		return this.roleService.addRole(role);

  	}
      
    @GetMapping("/AllRole")
	@ResponseBody
	public List<Role> getRoleLists() { 
		List<Role> list = roleService.retrieveAllRole(); 
		return list; 
	} 
    @RequestMapping(value = "/DeleteNews/{idRole}", method = RequestMethod.DELETE)
    public String deleteRole(@PathVariable("idRole") Long idRole){
		return this.roleService.deleteRole(idRole);
    }
    
    

}
