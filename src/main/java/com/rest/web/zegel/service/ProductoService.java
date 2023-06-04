package com.rest.web.zegel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.web.zegel.dao.IProductoDao;
import com.rest.web.zegel.dao.IUsuarioDao;
import com.rest.web.zegel.models.Producto;
import com.rest.web.zegel.models.Usuario;

@Service
public class ProductoService implements IProductoService{

	private IProductoDao productoDao;
	
	
	
	
	public ProductoService(IProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	@Override
	public List<Producto> listarProductos() {
		return productoDao.findAll();
	}

	@Override
	public Producto buscarIdProducto(Integer id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public void eliminar(Integer id) {
		productoDao.deleteById(id);	
	}



}
