package com.rest.web.zegel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.zegel.models.Producto;
import com.rest.web.zegel.service.IProductoService;
import com.rest.web.zegel.utilidades.Utilidades;

@RestController
@RequestMapping("/api/productos")
public class ApiController {

	private IProductoService productoService;

	public ApiController(IProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping("/index/{nombre}")
	public String index(@PathVariable String nombre) {
		return "METODO GET: " + nombre;
	}

	@GetMapping("/index-response")
	public ResponseEntity<String> indexResponse() {
		return ResponseEntity.ok("METODO GET");
	}

	@GetMapping("/listar-producto/")
	public ResponseEntity<Object> indexResponsePersonalizado() {
		return Utilidades.generateResponse(HttpStatus.OK, "ResponseEntity personalizado");
	}

	@GetMapping("/productos")
	public List<Producto> listar() {
		return productoService.listarProductos();
	}

	@GetMapping("/productos/{id}")
	public Producto listarId(@PathVariable Integer id) {
		return productoService.buscarIdProducto(id);
	}

	@PostMapping("/productos")
	public ResponseEntity<Object> guardarProducto(@RequestBody Producto producto) {
		productoService.guardar(producto);
		return Utilidades.generateResponse(HttpStatus.CREATED, "Producto Creado Satisfactoriamente");
	}

	@PutMapping("/productos")
	public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto) {

		Producto pr = productoService.buscarIdProducto(producto.getId());

		if (pr == null) {
			return Utilidades.generateResponse(HttpStatus.BAD_REQUEST, "Producto No se encontró");
		}
		productoService.guardar(producto);

		return Utilidades.generateResponse(HttpStatus.CREATED, "Producto Actualizado Satisfactoriamente");
	}

	@DeleteMapping("/productos")
	public ResponseEntity<Object> eliminarProducto(@RequestBody Producto producto) {

		Producto pr = productoService.buscarIdProducto(producto.getId());

		if (pr == null) {
			return Utilidades.generateResponse(HttpStatus.BAD_REQUEST, "Producto No se encontró");
		}
		productoService.eliminar(producto.getId());

		return Utilidades.generateResponse(HttpStatus.OK, "Producto Eliminado Satisfactoriamente");
	}

	@PostMapping("/recibir")
	public String recibir() {
		return "METODO POST";
	}

}
