package cl.yet.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cl.yet.system.dto.AnioMovie;
import cl.yet.system.dto.Movie;
import cl.yet.system.dto.Recurso;
import cl.yet.system.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService{
	
	private static final String Uri = "http://localhost:8080";
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getMoviesAll(){
		
		List<Movie> movieLista = new ArrayList<Movie>();
		try {
			RestTemplate clientM = new RestTemplate();
	        final HttpHeaders headers = new HttpHeaders();
	        
	        final HttpEntity<String> entity = new HttpEntity<String>(headers);
	        ResponseEntity<String> response = clientM.exchange(Uri, HttpMethod.GET, entity, String.class);
	        
	        String output = response.getBody();
	        
	        Gson gson=new Gson();
	        List<Recurso> recursoHolders = gson.fromJson(output, new TypeToken<List<Recurso>>(){}.getType());
	        
	        for (int i = 0; i < recursoHolders.size(); i++) {
	        	System.out.println("Nombre: "+recursoHolders.get(i).getNombre());
	        	AnioMovie am = movieRepository.findById(recursoHolders.get(i).getId());
	        	System.out.println("Año: "+am.getAnio());
	        }
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return null;
		
	}

}
