package spring.modelo.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import spring.modelo.model.LibroDTO;
@Service
public class LibroServiceImpl implements LibroService  {
	ArrayList<LibroDTO> libros = new ArrayList<>(Arrays.asList(
			new LibroDTO(1,"Cien años de soledad", "Gabriel García Márquez", false,"a1"),
			new LibroDTO(2,"Viajes Locos", "George Orwell", false,"e2"),
			new LibroDTO(3,"Un mundo feliz", "Aldous Huxley", false,"e3"),
			new LibroDTO(4,"El retrato de Dorian Gray", "Oscar Wilde", false,"r9"),
			new LibroDTO(5,"Los pilares de la tierra", "Ken Follett", false,"tn")));

	@Override
	public LibroDTO getLibroByid(Integer id) {
		//retornar el libro por id de la lista libros
		for(LibroDTO lib : libros) {
			if(lib.getId()==id) {
				return lib;
			}
		}
		return null;
	}



}
