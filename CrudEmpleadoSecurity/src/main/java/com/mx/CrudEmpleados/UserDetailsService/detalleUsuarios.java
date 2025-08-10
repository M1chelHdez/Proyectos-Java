package com.mx.CrudEmpleados.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.CrudEmpleados.dao.UsuariosDao;
import com.mx.CrudEmpleados.dominio.Usuarios;

@Service
public class detalleUsuarios implements UserDetailsService{

	@Autowired
	UsuariosDao usuariosDao;
	
	Usuarios usuario = null;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuarios usuario = usuariosDao.findByNombre(username);
		System.out.println("Recibiendo usuario-->"+usuario);
	
//	Usuarios usuario = null;
//	for(Usuarios u :usuariosDao.findAll()) {
//		if (u.getNombre().equals(username)) {
//			usuario = u;
//		}
//	}
//	
	
	List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//	agregar a la lista de usuarios los roles
	roles.add(new SimpleGrantedAuthority("ADMIN"));
		
//	autorizacion
	UserDetails userDetails = new User(usuario.getNombre(), usuario.getPassword(), roles);
	return userDetails;
	}
}
