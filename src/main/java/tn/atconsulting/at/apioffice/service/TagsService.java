package tn.atconsulting.at.apioffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.Tags;
import tn.atconsulting.at.apioffice.repository.TagsRepository;
@Service
public class TagsService {
	@Autowired
	TagsRepository 	tagsRepository;

	
	public Tags addTags(Tags t)  {
		

		return tagsRepository.save(t);
	}
	
	
	@Autowired
	public List<Tags> retrieveAllTags() {
		// TODO Auto-generated method stub
		List<Tags> tags=(List<Tags>)tagsRepository.findAll();
		for (Tags t : tags) {
			//L.info("client +++"+cl);
		}
		
		return tags;
	}

	public String deleteTags(Long id) {
		// TODO Auto-generated method stub
		tagsRepository.deleteById(id);
		return "ok";
	}


}
