package com.aws.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aws.demo.entity.Role;
import com.aws.demo.entity.Usuario;
import com.aws.demo.permissoes.PermissaoEnum;
import com.aws.demo.service.UsuarioService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setUsername("admin");
		usuario.setPassword("123456");

		List<Role> roles = new ArrayList<>();

		Role roleAdmin = new Role();
		roleAdmin.setNome(PermissaoEnum.ADMINISTRADOR);

		Role roleUsuario = new Role();
		roleUsuario.setNome(PermissaoEnum.USUARIO);

		roles.add(roleAdmin);
		roles.add(roleUsuario);

		usuario.setRoles(roles);

		usuarioService.salvarUsuario(usuario);
		
	}

}
