package tn.atconsulting.at.apioffice.repository;



import org.springframework.data.repository.CrudRepository;

import tn.atconsulting.at.apioffice.domain.dto.Client;




public interface ClientRepository extends CrudRepository<Client,Long> {
	Client findByEmail(String email);

}
