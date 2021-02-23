package com.projeto.gestaomultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.gestaomultas.domain.LogAplicacao;

@Repository
public interface LogRepository extends JpaRepository<LogAplicacao, Long> { }
