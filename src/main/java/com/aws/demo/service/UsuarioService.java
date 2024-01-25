package com.aws.demo.service;

import java.util.List;
import java.util.Optional;

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
			.map(role -> iRoleRepository.findByNome(role.getNome())).toList());
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return this.iUsuarioRepository.save(usuario);
	}
	
	public Usuario atualizarUsuario (Usuario usuario) {
		
		usuario.setRoles(
				
				usuario.getRoles()
					.stream()
					.map(role -> iRoleRepository.findByNome(role.getNome())).toList());
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return this.iUsuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> obterUsuarioId(Long usuarioId ) {
		return this.iUsuarioRepository.findById(usuarioId);
	}
	
	public void deletarUsuario (Usuario usuario) {
		this.iUsuarioRepository.deleteById(usuario.getId());
	}
	
	public List<Usuario> obtemUsuario(){
		return this.iUsuarioRepository.findAll();	}
	
}
