package tn.atconsulting.at.apioffice.repository;

import org.springframework.data.repository.CrudRepository;

import tn.atconsulting.at.apioffice.domain.dto.Tags;
import tn.atconsulting.at.apioffice.domain.dto.Notification;

public interface TagsRepository extends CrudRepository<Tags,Long> {


}
