package com.rest.web.zegel.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.zegel.models.Usuario;
import com.rest.web.zegel.service.IUsuarioService;


@Component
public class UserLogin implements UserDetailsService{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.buscarPorCorreo(username);
		if(usuario == null) { 
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return new User(usuario.getCorreo(), usuario.getPassword(), true, true, true, true, authorities);
	}

}
