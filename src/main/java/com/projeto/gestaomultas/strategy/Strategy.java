package com.projeto.gestaomultas.strategy;

import com.projeto.gestaomultas.domain.Domain;

public interface Strategy {

  public String processar(final Domain domain);

  public Boolean verificarInstancia(final Domain domain);
}
