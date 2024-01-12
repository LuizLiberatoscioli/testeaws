package com.aws.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.demo.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
