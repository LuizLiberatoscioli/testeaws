package com.aws.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aws.demo.entity.Usuario;
import com.aws.demo.repository.IRoleRepository;
import com.aws.demo.repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	@Autowired
	private IRoleRepository iRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usuario salvarUsuario(Usuario usuario) {
		
		usuario.setRoles(
		
		usuario.getRoles()
			.stream()
			.map(role -> iRoleRepository.findByname(role.getNome())).toList());
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return this.iUsuarioRepository.save(usuario);
	}
	
	public Usuario atualizarUsuario (Usuario usuario) {
		
		usuario.setRoles(
				
				usuario.getRoles()
					.stream()
					.map(role -> iRoleRepository.findByname(role.getNome())).toList());
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return this.iUsuarioRepository.save(usuario);
	}
	
	public void deletarUsuario (Usuario usuario) {
		this.iUsuarioRepository.deleteById(usuario.getId());
	}
	
	public List<Usuario> obtemUsuario(){
		return this.iUsuarioRepository.findAll();	}
	
}
