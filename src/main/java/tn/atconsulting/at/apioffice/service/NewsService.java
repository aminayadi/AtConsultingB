package tn.atconsulting.at.apioffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.News;
import tn.atconsulting.at.apioffice.repository.NewsRepository;
@Service
public class NewsService {
	@Autowired
	NewsRepository 	newsRepository;

	
	public News addNews(News n)  {
		

		return newsRepository.save(n);
	}
	
	
	@Autowired
	public List<News> retrieveAllNews() {
		// TODO Auto-generated method stub
		List<News> news=(List<News>)newsRepository.findAll();
		for (News n : news) {
			//L.info("client +++"+cl);
		}
		
		return news;
	}

	public String deleteNews(Long id) {
		// TODO Auto-generated method stub
		newsRepository.deleteById(id);
		return "ok";
	}



}
