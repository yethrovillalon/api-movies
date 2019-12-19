package cl.yet.system.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import cl.yet.system.dto.AnioMovie;

@Repository
public class AnioMovieRepositoryImpl implements MovieRepository{

	private final MongoOperations mongoOperations;
	
	@Autowired
    public AnioMovieRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;

    }

	public AnioMovie findById(int id) {
		
		
		AnioMovie a = AnioMovie.builder().build();
		try {
			System.out.println("1: "+id);
			System.out.println(this.mongoOperations.getCollectionNames());
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("id").is(id));
			
			//a = this.mongoOperations.findOne(query2, AnioMovie.class);
			System.out.println("query2 - " + query2.toString());
			System.out.println("2: "+this.mongoOperations.findOne(query2, AnioMovie.class,"aniomovie"));
			
		} catch (Exception e) {
			System.out.println("Error find id: "+e.getMessage());
		}
        return a;

    }
}
