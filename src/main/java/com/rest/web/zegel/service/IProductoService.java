package com.rest.web.zegel.service;

import java.util.List;

import com.rest.web.zegel.models.Producto;

public interface IProductoService {
	
	List<Producto> listarProductos();
	
	Producto buscarIdProducto(Integer id);
	
	Producto guardar(Producto producto);
	
	void eliminar(Integer id);

}
