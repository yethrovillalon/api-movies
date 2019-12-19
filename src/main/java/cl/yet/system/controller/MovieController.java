package cl.yet.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.yet.system.service.IMovieService;
import cl.yet.system.dto.Movie;

@RestController
public class MovieController {
	
	@Autowired
	IMovieService movieService;
	
	@GetMapping("")
	public List<Movie> getMovies(){
		return movieService.getMoviesAll();
	}

}
