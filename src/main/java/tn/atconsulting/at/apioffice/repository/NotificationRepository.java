package tn.atconsulting.at.apioffice.repository;

import org.springframework.data.repository.CrudRepository;

import tn.atconsulting.at.apioffice.domain.dto.Notification;

public interface NotificationRepository extends CrudRepository<Notification,Long> {
	Notification findByText(String text);

}