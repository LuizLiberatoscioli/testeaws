package com.aws.demo.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.demo.entity.Tarefa;

@Repository
public interface GerenciadorTarefasRepository extends JpaRepository<Tarefa , Long>{
	
	Page<Tarefa> findByTituloContaining(String titulo , Pageable pegeable);
	
	Page<Tarefa> findAll(Pageable pegeable);

}
