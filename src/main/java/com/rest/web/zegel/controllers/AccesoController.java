package com.rest.web.zegel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.zegel.models.Usuario;
import com.rest.web.zegel.service.IUsuarioService;
import com.rest.web.zegel.jwt.AuthRequest;
import com.rest.web.zegel.jwt.AuthResponse;

import com.rest.web.zegel.jwt.JwtTokenUtil;

@RestController
@RequestMapping("/api/v1")
public class AccesoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/*{"correo":"elvis@hotmail.com", "password":"123456"}*/
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request)
	{
		try {
			
			Authentication authentication = this.authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword()));
			System.out.println(authentication);
			
			Usuario user = usuarioService.buscarPorCorreo(request.getCorreo());
			
			System.out.println(user.getCorreo());
			
			String accessToken = jwtUtil.generarToken(user);
			
			System.out.println(accessToken);
			
			AuthResponse response = new AuthResponse(request.getCorreo(), accessToken);
			
			return ResponseEntity.ok(response);
			
		} catch (BadCredentialsException e) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
