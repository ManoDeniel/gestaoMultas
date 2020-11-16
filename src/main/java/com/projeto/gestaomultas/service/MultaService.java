package com.projeto.gestaomultas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Multa;
import com.projeto.gestaomultas.domain.MultaRepository;

@Service
public class MultaService {

  @Autowired private MultaRepository multaRepository;

  public List<Multa> findAll() {
    return multaRepository.findAll();
  }
}
