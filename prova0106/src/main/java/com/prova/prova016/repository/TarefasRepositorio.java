package com.prova.prova0106.repository;

import com.prova.prova0106.entity.Tarefas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepositorio extends JpaRepository<Tarefas, Long> {
    
}