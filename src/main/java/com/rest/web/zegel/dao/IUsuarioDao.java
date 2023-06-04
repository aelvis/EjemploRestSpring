package com.rest.web.zegel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.web.zegel.models.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

	public Usuario findByCorreo(String correo);
	
}
