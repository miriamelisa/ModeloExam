package spring.modelo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
	private Integer id;
	private String titulo;
	private String autor;
	private Boolean reservado;
	
	private String code;
}
