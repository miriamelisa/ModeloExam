package spring.modelo.services;

import java.util.Arrays;
import java.util.List;

import spring.modelo.model.UsuarioDTO;

public class UserServiceImpl implements UserService{
	
	List<UsuarioDTO> usuarios = Arrays.asList(
			new UsuarioDTO(1, "Angel", "gynny@gmail.com"),
			new UsuarioDTO(2, "Gynny", "Maria@gmail.com"),
			new UsuarioDTO(3, "José", "Juana@gmail.com"));

	@Override
	public UsuarioDTO getUsuario(Integer id) {
		
		return null;
	}

	@Override
	public Boolean existUsuario(Integer id) {
		for(UsuarioDTO u : usuarios) {
			if(u.getId() ==id) {
				return true;
			}
		}
		
		return false;
	}

}
