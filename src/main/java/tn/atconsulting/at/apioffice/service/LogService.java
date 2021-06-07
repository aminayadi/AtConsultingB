package tn.atconsulting.at.apioffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.Log;
import tn.atconsulting.at.apioffice.repository.LogRepository;
@Service
public class LogService {
	@Autowired
	LogRepository 	logRepository;

	
	public Log addLog(Log l)  {
		

		return logRepository.save(l);
	}
	
	
	@Autowired
	public List<Log> retrieveAllLog() {
		// TODO Auto-generated method stub
		List<Log> log=(List<Log>)logRepository.findAll();
		for (Log l : log) {
			//L.info("client +++"+cl);
		}
		
		return log;
	}

	public String deleteLog(Long id) {
		// TODO Auto-generated method stub
		logRepository.deleteById(id);
		return "ok";
	}


}
