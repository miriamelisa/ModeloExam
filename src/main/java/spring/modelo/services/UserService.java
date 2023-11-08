package spring.modelo.services;

import spring.modelo.model.UsuarioDTO;

public interface UserService {

	UsuarioDTO getUsuario(Integer id);
	
	Boolean existUsuario(Integer id);

}
