package tn.atconsulting.at.apioffice.repository;

import org.springframework.data.repository.CrudRepository;

import tn.atconsulting.at.apioffice.domain.dto.Event;

public interface EventRepository extends CrudRepository<Event,Long>{

}