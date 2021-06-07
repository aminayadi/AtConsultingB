package tn.atconsulting.at.apioffice.repository;

import org.springframework.data.repository.CrudRepository;

import tn.atconsulting.at.apioffice.domain.dto.News;


public interface NewsRepository extends CrudRepository<News,Long>{

}