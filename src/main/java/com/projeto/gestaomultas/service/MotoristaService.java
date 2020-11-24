package com.projeto.gestaomultas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.repository.MotoristaRepository;

@Service
public class MotoristaService {

  @Autowired private MotoristaRepository motoristaRepository;

  public List<Motorista> findAll() {
    return motoristaRepository.findAll();
  }
}
