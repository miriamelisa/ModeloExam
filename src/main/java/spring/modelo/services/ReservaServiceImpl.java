package spring.modelo.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				throw new RuntimeException();//ReservationConflictException
				
			}
			
		}else {
			throw new RuntimeException();
					//BookNotFoundException(); si hacemos la exception tenemos q crear la clase excepcion
		}
		
		
		
	}

	@Override
	/*cancelReservation(Long bookId, Long userId): Un método para cancelar una reserva activa. Este debería 
	 * lanzar una ReservationConflictException si el usuario no tiene reservas activas de ese libro. 
	 * */
	public void cancelReservation(Integer bookId, Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/*getAllReservations(Long userId): Un método para obtener todas las reservas de un usuario. Este debería 
	 * lanzar una excepción ReservationConflictException si el usuario nunca ha reservado.
	 *  */
	public ArrayList<ReservaDTO> getAllReservations(Integer userId) {
		// TODO Auto-generated method stub
		return reservas;
	}
	//me creo u narray list 
	
}
