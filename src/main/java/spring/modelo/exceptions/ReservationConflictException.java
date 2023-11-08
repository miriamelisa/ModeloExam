package spring.modelo.exceptions;
//tengo q hacer un constructor de la excepcion para q me envie el mensaje osea para q coja el mensaje 
public class ReservationConflictException extends RuntimeException {
	public ReservationConflictException(String string) {
		super(string);
	}

}
