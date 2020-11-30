package com.projeto.gestaomultas.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Preconditions;
import com.projeto.gestaomultas.dao.MotoristaDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;

@Service
public class ValidarCnh implements Strategy {

  @Autowired private MotoristaDAO motoristaDAO;

  @Override
  public String processar(final Domain domain) {
    Preconditions.checkArgument(!verificarInstancia(domain));
    return null;
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Motorista;
  }
}
