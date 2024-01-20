package com.aws.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.demo.entity.Role;
import com.aws.demo.permissoes.PermissaoEnum;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
	
	Role findByname(PermissaoEnum nome);

}
