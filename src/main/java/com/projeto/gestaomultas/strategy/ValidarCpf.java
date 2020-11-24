package com.projeto.gestaomultas.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.google.common.base.Preconditions;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.repository.MotoristaRepository;

@Service
public class ValidarCpf implements Strategy {

  @Autowired private MotoristaRepository motoristaRepository;

  public void processar(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    // TODO validarDigitos()
    final Boolean exists = motoristaRepository.exists(Example.of(
        Motorista.builder()
        .cpf(motorista.getCpf())
        .build()
        ));
    Preconditions.checkArgument(!exists);
    
  }

}
