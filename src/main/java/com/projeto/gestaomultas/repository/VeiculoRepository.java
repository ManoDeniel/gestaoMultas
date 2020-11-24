package com.projeto.gestaomultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.gestaomultas.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> { }
