package cl.yet.system.dto;

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
public class Movie {
	
	private int id;
	private String nombre;
	private int anio;
	private String tipo;
	private String descripcion;

}
