package com.rest.web.zegel.utilidades;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utilidades {
	public static ResponseEntity<Object> generateResponse(HttpStatus status, String mensaje){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			map.put("Fecha", new Date());
			map.put("Status", status.value());
			map.put("Mensaje", mensaje);
			
			return new ResponseEntity<Object>(map,status);
			
		} catch (Exception e) {
			map.put("Fecha", new Date());
			map.put("Status", status.value());
			map.put("Mensaje", mensaje);
			return new ResponseEntity<Object>(map,status);
		}
	}
}
