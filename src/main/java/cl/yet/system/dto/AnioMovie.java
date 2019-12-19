package cl.yet.system.dto;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "aniomovie")
public class AnioMovie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023949328451239337L;
	private int id;
	private int anio;
}
