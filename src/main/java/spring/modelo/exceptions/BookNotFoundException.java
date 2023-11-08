package spring.modelo.exceptions;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String string) {
		super(string);
	}
	
}
