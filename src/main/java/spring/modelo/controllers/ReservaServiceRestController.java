package spring.modelo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.modelo.services.ReservaService;

@RestController
@RequestMapping("/reservations")
public class ReservaServiceRestController {
	ReservaService reservaservice;
	
	@PostMapping("/{bookId}/{userId}")
	//este reserveBook es la interfaz q me permite optener el idbook y el userId por
	//lo q el metodo tiene q  estar en la interfaz DE SERVICIOS Y EN su implementacion
	public ResponseEntity<?> reserveBook( @PathVariable Integer bookId, @PathVariable Integer userId) {
		reservaservice.reserveBook(bookId,userId);
		return ResponseEntity.ok().build();
	}
	//me da todas las reservas
	@GetMapping()
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(reservaservice.getAllReservations());
	}
	//me busca una serserva para cancelarla 
	//la logica de cancelacion esta en ReservaServiceImpl por eso llamo a la interfaz ReservaService
	
	@PatchMapping("/books/{bookId}/users/{userId}")
	public ResponseEntity<?> cancelReservation(@PathVariable Integer bookId, @PathVariable Integer userId){
		
		reservaservice.cancelReservation(bookId, userId);
		
		return ResponseEntity.noContent().build();
		
	}
		
}
