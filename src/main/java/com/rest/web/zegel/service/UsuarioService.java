package com.rest.web.zegel.service;

import org.springframework.stereotype.Service;

import com.rest.web.zegel.dao.IUsuarioDao;
import com.rest.web.zegel.models.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	private IUsuarioDao usuarioDao;
	
	public UsuarioService(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	@Override
	public Usuario buscarPorCorreo(String nombre) {
		return usuarioDao.findByCorreo(nombre);
	}

}
