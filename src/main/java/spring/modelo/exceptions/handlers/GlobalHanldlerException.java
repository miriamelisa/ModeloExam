package spring.modelo.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.modelo.exceptions.BookNotFoundException;
import spring.modelo.exceptions.ReservationConflictException;
//ESTA CLASE MANEJA DEA EXCEPCIONES
@RestControllerAdvice
public class GlobalHanldlerException {
	
	
	@ExceptionHandler( BookNotFoundException.class )
	public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {
//es NOT_FOUND porque estamos hablando de libro noencontrado
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Book Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Book");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
	@ExceptionHandler( ReservationConflictException.class )
	public ProblemDetail handleReservationConflictException(ReservationConflictException e) {
//es BAT_REQUETS porque es una mala peticion, me pides un libro q ya esta reservado
		//tienes q validar antes q el libro no este reservado 
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Reserva Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Reservation");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	@ExceptionHandler( MethodArgumentNotValidException.class )
	public ProblemDetail handleReservationConflictException(MethodArgumentNotValidException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		problemDetail.setTitle("Custom Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Book");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	

}
