package com.projeto.gestaomultas.command;

import com.projeto.gestaomultas.domain.Domain;

public interface Command {

  Object executar(final Domain domain);
}
