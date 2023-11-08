package spring.modelo.services;

import java.util.ArrayList;

import spring.modelo.model.ReservaDTO;

public interface ReservaService {
	//Me retorna reservaDTO NORMALMENTE NO SE RETORNA OBJETOS SOLO REPSOUESTAS 
	//Estos metodos me los pide en controllers para hacer los controllers NECESITO ESTA INTERFAZ
	// aqui la interfaz se llama reserveBook ypara implementarlo en controler tengo q llamarla por el nombre
	ReservaDTO reserveBook(Integer bookId, Integer userId);
	//no me retorna nada
	void cancelReservation(Integer bookId, Integer userId);
	//ME RETORNA UNA LISTA DE Reserva DTO 
	ArrayList<ReservaDTO> getAllReservations();
	ArrayList<ReservaDTO> getAllReservations(Integer userId);	
	
	ArrayList<ReservaDTO> getActiveReservation(Integer userId);
	
	

	

}
