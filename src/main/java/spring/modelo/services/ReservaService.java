package spring.modelo.services;

import java.util.ArrayList;

import spring.modelo.model.ReservaDTO;

public interface ReservaService {
	//Me retorna reservaDTO NORMALMENTE NO SE RETORNA OBJETOS SOLO REPSOUESTAS 
	ReservaDTO reserveBook(Integer bookId, Integer userId);
	//no me retorna nada
	void cancelReservation(Integer bookId, Integer userId);
	//ME RETORNA UNA LISTA DE Reserva DTO 
	ArrayList<ReservaDTO> getAllReservations(Integer userId);

	

}
