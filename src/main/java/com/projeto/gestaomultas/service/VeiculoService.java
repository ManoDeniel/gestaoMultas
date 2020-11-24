package com.projeto.gestaomultas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Veiculo;
import com.projeto.gestaomultas.repository.VeiculoRepository;

@Service
public class VeiculoService {

  @Autowired private VeiculoRepository veiculoRepository;

  public List<Veiculo> findAll() {
    return veiculoRepository.findAll();
  }
}
