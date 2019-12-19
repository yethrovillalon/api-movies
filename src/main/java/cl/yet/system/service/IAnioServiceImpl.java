package cl.yet.system.service;

import org.springframework.beans.factory.annotation.Autowired;

import cl.yet.system.dto.AnioMovie;
import cl.yet.system.repository.MovieRepository;

public class IAnioServiceImpl implements IAnioService{

	@Autowired
	private MovieRepository movieRepository;
	
	public AnioMovie findById(int id) {
		
		
		AnioMovie am = movieRepository.findById(id);
		
		return am;
	}
}
