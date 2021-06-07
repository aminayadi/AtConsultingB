package tn.atconsulting.at.apioffice.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.Notification;

import tn.atconsulting.at.apioffice.repository.NotificationRepository;

@Service
public class NotificationService {
	@Autowired
	NotificationRepository 	notificationRepository;

	
	public Notification addNotification(Notification nl)  {
		

		return notificationRepository.save(nl);
	}
	
	
	@Autowired
	public List<Notification> retrieveAllNotification() {
		// TODO Auto-generated method stub
		List<Notification> notification=(List<Notification>)notificationRepository.findAll();
		for (Notification nl : notification) {
			//L.info("client +++"+cl);
		}
		
		return notification;
	}

	public String deleteNotification(Long id) {
		// TODO Auto-generated method stub
		notificationRepository.deleteById(id);
		return "ok";
	}


}
