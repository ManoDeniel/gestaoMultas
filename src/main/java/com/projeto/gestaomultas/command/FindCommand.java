package com.projeto.gestaomultas.command;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.facade.Fachada;

@Component
public class FindCommand implements Command {

  @Autowired private Fachada fachada;

  @Override
  public List<? extends Domain> executar(final Domain domain) {
    return fachada.find(domain);
  }

}
