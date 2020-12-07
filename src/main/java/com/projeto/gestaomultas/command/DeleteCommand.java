package com.projeto.gestaomultas.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.facade.Fachada;

@Component
public class DeleteCommand implements Command {

  @Autowired private Fachada fachada;

  @Override
  public String executar(final Domain domain) {
    return fachada.delete(domain);
  }

}
