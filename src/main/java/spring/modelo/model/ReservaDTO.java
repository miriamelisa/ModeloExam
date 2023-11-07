package spring.modelo.model;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

	private Integer id;
	private Integer libroId;
	private Integer usuarioId;
	private LocalDate fechaReserva;
	private LocalDate returnDate;
}
