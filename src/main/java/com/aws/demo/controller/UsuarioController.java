package com.aws.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.demo.entity.Usuario;
import com.aws.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.salvarUsuario(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizarUsuario (@RequestBody Usuario usuario){
		return new ResponseEntity<> (usuarioService.atualizarUsuario(usuario), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obtemUsuario (){
		return new ResponseEntity<> (usuarioService.obtemUsuario(), HttpStatus.OK);
	}
	
	@DeleteMapping
	public void excluirUsuario(@RequestBody Usuario usuario) {
		usuarioService.deletarUsuario(usuario);
	}

}
