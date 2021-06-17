package tn.atconsulting.at.apioffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.Role;
import tn.atconsulting.at.apioffice.repository.RoleRepository;
@Service
public class RoleService {
	@Autowired
	RoleRepository 	roleRepository;

	
	public Role addRole(Role r)  {
		

		return roleRepository.save(r);
	}
	
	
	@Autowired
	public List<Role> retrieveAllRole() {
		// TODO Auto-generated method stub
		List<Role> role=(List<Role>)roleRepository.findAll();
		for (Role r : role) {
			//L.info("client +++"+cl);
		}
		
		return role;
	}

	public String deleteRole(Long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
		return "ok";
	}


}
