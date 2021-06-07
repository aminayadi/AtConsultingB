package tn.atconsulting.at.apioffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.Event;
import tn.atconsulting.at.apioffice.repository.EventRepository;
@Service
public class EventService {
	@Autowired
	EventRepository 	eventRepository;

	
	public Event addEvent(Event ev)  {
		

		return eventRepository.save(ev);
	}
	
	
	@Autowired
	public List<Event> retrieveAllEvent() {
		// TODO Auto-generated method stub
		List<Event> event=(List<Event>)eventRepository.findAll();
		for (Event ev : event) {
			//L.info("client +++"+cl);
		}
		
		return event;
	}

	public String deleteEvent(Long id) {
		// TODO Auto-generated method stub
		eventRepository.deleteById(id);
		return "ok";
	}


}
