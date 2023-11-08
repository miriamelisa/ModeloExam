package spring.modelo.services;

import java.util.List;

import spring.modelo.model.LibroDTO;

public interface LibroService {

	LibroDTO getLibroByid(Integer id );//
	
	List<LibroDTO> getAllbooks();//
	
	void createBook(LibroDTO book);//
	
	Boolean IsReserved(Integer bookId) ;
	
	String getCode(Integer bookId);//
	
}
