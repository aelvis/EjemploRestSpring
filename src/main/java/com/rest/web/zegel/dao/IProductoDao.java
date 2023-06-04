package com.rest.web.zegel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.web.zegel.models.Producto;

public interface IProductoDao extends JpaRepository<Producto, Integer>{

}
