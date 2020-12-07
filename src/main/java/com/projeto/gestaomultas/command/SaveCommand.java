package com.projeto.gestaomultas.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.facade.Fachada;

@Component
public class SaveCommand implements Command {

  @Autowired private Fachada fachada;

  @Override
  public String executar(final Domain domain) {
    return fachada.save(domain);
  }

}
