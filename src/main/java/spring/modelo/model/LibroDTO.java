package spring.modelo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.modelo.validators.BookCodevalidator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
	private Integer id;
	private String titulo;
	private String autor;
	private Boolean reservado;
	@BookCodevalidator
	private String code;
	
	/*OTROS EJEMPLOS DE VALIDACIONES 
	@Min(value=0, message="no admite números negativos")
	private int id;
	
	@NotBlank
	private String name;
	
	@Email(message = "Email should be valid")
	private String email;
	
	 */
}
