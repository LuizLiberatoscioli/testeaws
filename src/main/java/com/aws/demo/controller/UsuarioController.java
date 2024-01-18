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
	public ResponseEntity<String> salvarUsuario(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<>("Novo usuario criado" + usuarioSalvo.getUsername(), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<String> atualizarUsuario (@RequestBody Usuario usuario){
		Usuario usuarioAtualizado = usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<>("Novo usuario criado" + usuarioAtualizado.getUsername(), HttpStatus.OK);
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
