package com.aws.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.demo.entity.Tarefa;

@Repository
public interface GereciadorTarefasRepository extends JpaRepository<Tarefa , Long>{

}
