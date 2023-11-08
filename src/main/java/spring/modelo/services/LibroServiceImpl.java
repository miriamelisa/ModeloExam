package spring.modelo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.modelo.exceptions.BookNotFoundException;
import spring.modelo.model.LibroDTO;
@Service
public class LibroServiceImpl implements LibroService  {
	ArrayList<LibroDTO> libros = new ArrayList<>(Arrays.asList(
			new LibroDTO(1,"Cien años de soledad", "Gabriel García Márquez", false,"a1"),
			new LibroDTO(2,"Viajes Locos", "George Orwell", false,"e2"),
			new LibroDTO(3,"Un mundo feliz", "Aldous Huxley", false,"e3"),
			new LibroDTO(4,"El retrato de Dorian Gray", "Oscar Wilde", false,"r9"),
			new LibroDTO(5,"Los pilares de la tierra", "Ken Follett", false,"tn")));

	
	
	
	
	
	
	
	//List<LibroDTO> getAllbooks();
	@Override
	public ArrayList<LibroDTO> getAllbooks() {
		
		return libros;
	}
	//void createBook(LibroDTO book);
	@Override
	public void createBook(LibroDTO book) {
		libros.add(book);
		
	}
	//Boolean IsReserved(Integer bookId) ;
	@Override
	public Boolean IsReserved(Integer id) {
		String code = getCode(id);
		for (LibroDTO b : libros) {

			if (b.getCode().equals(code)) {
				return b.getReservado();
			}
		}

		return null; // libro no encontrado
	}
	//String getCode(Integer bookId);
	@Override
	public String getCode(Integer bookId) {
		for (LibroDTO b : libros) {
			if (b.getId() == bookId) {
				return b.getCode();
			}
		}

		throw new BookNotFoundException("No existe un libro con el id: " + bookId); // libro no encontrado
	}
	
	//LibroDTO getLibroByid(Integer id );
	@Override
	public LibroDTO getLibroByid(Integer bookId) {		
		
		for(LibroDTO bo: libros) {
			if(bo.getId() == bookId) {			
				return bo;
			}
		}
			
		return null;
	}

	
}