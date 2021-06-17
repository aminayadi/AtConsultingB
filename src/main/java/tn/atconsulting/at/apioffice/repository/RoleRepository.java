package tn.atconsulting.at.apioffice.repository;

import org.springframework.data.repository.CrudRepository;


import tn.atconsulting.at.apioffice.domain.dto.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{
	
	Role findByRole(String role);

}
