package com.projeto.gestaomultas.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.dao.MultaDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Multa;

@Component
public class ValidarNumeroInfracao implements Strategy {

  @Autowired private MultaDAO multaDAO;

  @Override
  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Multa multa = (Multa) domain;
      return validarNumero(multa);
    }
    return "Erro interno do sistema!";
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Multa;
  }

  private String validarNumero(final Multa multa) {
    final Optional<Multa> optional = multaDAO.findByNumeroInfracao(multa.getNumeroInfracao());
    if (optional.isEmpty()) {
      return null;
    }
    return "Número de infração indisponível!";
  }
}
