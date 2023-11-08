package spring.modelo.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.modelo.exceptions.BookNotFoundException;
import spring.modelo.exceptions.ReservationConflictException;
import spring.modelo.model.LibroDTO;
import spring.modelo.model.ReservaDTO;
//PARA Q SEPA Q ES UN BIM INYECTADO AL CONTROLADOR
@Service
public class ReservaServiceImpl implements ReservaService {
	
	ArrayList<ReservaDTO> reservas=new ArrayList<ReservaDTO>();
	Integer cont=1;//inicializador de la lista de reservas
	//inyecsion de dependencia para usar la interfaz LibroService;
	//libroService es una variable de LibroService no es un objeto porq no hago new
	@Autowired
	LibroService libroService;
	UserService userService;
	//otra forma de hacer una inyeccion es hacer un constructor q pase la variable
	/*public ReservaServiceImpl(LibroService libroService) {
		this.libroService=libroService;
	}*/
	
	
	@Override
	/*reserveBook(Long bookId, Long userId): Un método para realizar una reserva. Este debería 
	 * lanzar una BookNotFoundException si el libro no existe y una ReservationConflictException 
	 * si el libro ya está reservado.*/
	public ReservaDTO reserveBook(Integer bookId, Integer userId) {
		// logica de reservarLibro 
		//de reserva necesito FechaReserva y fecha de Retorno(para ver si esta devuelto)
		//verificar si el libro existe MIRO EN LA INTERFAZ LIBROSERVICE
		//buscar Libro para saber si esta reservado o esta accesible
		//atributo Reserva de Libro cambia a false
		//creamos un nuevo registro de reserva
		LibroDTO libro=libroService.getLibroByid(bookId);
		
		if(libro !=null) {
			if(libro.getReservado()){
				libro.setReservado(true);
				ReservaDTO reserva=new ReservaDTO(cont,bookId,userId,LocalDate.now(),null);
				cont++;
				reservas.add(reserva);
				return reserva;
			}else {
				throw new ReservationConflictException("El libro ya esta reservado");
				//Esto en principio da error porq no existe el ocnstructor
				
			}
			
		}else {
			throw new BookNotFoundException("El libro no es encuentra");
					//BookNotFoundException(); si hacemos la exception tenemos q crear la clase excepcion
		}
		
		
		
	}

	@Override
	/*cancelReservation(Long bookId, Long userId): Un método para cancelar una reserva activa. Este debería 
	 * lanzar una ReservationConflictException si el usuario no tiene reservas activas de ese libro. 
	 * */
	public void cancelReservation(Integer bookId, Integer userId) {
		
		for (ReservaDTO re : reservas) {

			if (re.getLibroId() == bookId && re.getUsuarioId() == userId) {
				if (re.getReturnDate() != null) {
					//me sirve con la Except¡cion ya creada para el anterior gettin solo cambio el mensaje
					throw new ReservationConflictException(
							"la persona con id: " + userId + " ya ha devuelto el libro con id" + bookId);
				} else {
					re.setReturnDate(LocalDate.now());
				}

			} else {
				throw new ReservationConflictException(
						"No existe una reserva para el user id:" + userId + " y el libro con id: " + bookId);

			}
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	
	public ArrayList<ReservaDTO> getActiveReservation(Integer userId) {
		//hago una lista de reservaciones HECHAS
		ArrayList<ReservaDTO> activeReservations = new ArrayList<>();
		for (ReservaDTO re : reservas) {
			if (re.getUsuarioId() == userId) {
				if (re.getReturnDate() == null) {
					activeReservations.add(re);
				}

			} else {
				//ESTA EXCEPTION  LA tengo en .exceptions solo cambio el mensaje
				throw new ReservationConflictException(
						"La persona con el user id:" + userId + " nunca ha reservado un libro ");
			}
		}

		return activeReservations;
	}
	//me creo u narray list 
	
	/*getAllReservations(Long userId): Un método para obtener todas las reservas de un usuario. Este debería 
	 * lanzar una excepción ReservationConflictException si el usuario nunca ha reservado.
	 *  */
	@Override
	public ArrayList<ReservaDTO> getAllReservations() {

		return reservas;
	}

	
	//QUIERO TODAS LAS RESERVAS DE UN USUARIO Y SI EL 
	//USUARIO NO TIENE RESERVAS ENVIO UN MENSAJE 
	@Override
	public ArrayList<ReservaDTO> getAllReservations(Integer userId) {
		ArrayList<ReservaDTO> reservations = new ArrayList<>();

		for (ReservaDTO re : reservas) {
			if (re.getUsuarioId() == userId) {
				reservations.add(re);
			}
		}

		if (reservations.isEmpty()) {
			throw new ReservationConflictException(
					"La persona con el user id:" + userId + " nunca ha reservado un libro ");
		}

		return reservations;
	}
	
}
