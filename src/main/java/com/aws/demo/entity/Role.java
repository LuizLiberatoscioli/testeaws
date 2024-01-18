package com.aws.demo.entity;

import java.io.Serializable;
import java.util.List;

import com.aws.demo.permissoes.PermissaoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private  Long id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PermissaoEnum nome;
	
	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private List<Usuario> usuarios;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public PermissaoEnum getNome() {
		return nome;
	}

	public void setNome(PermissaoEnum nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}
