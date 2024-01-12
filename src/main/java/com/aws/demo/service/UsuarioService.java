package com.aws.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.demo.entity.Usuario;
import com.aws.demo.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {
		return this.iUsuarioRepository.save(usuario);
	}
}
