package com.projeto.gestaomultas.strategy;

import com.projeto.gestaomultas.domain.Domain;

public interface Strategy {

  public void processar(final Domain domain);
}
