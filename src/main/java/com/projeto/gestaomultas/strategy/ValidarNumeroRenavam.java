package com.projeto.gestaomultas.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.dao.VeiculoDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Veiculo;

@Component
public class ValidarNumeroRenavam implements Strategy {

  @Autowired private VeiculoDAO veiculoDAO;

  @Override
  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Veiculo veiculo = (Veiculo) domain;
      return validarNumeroRenavam(veiculo);
    }
    return "Erro interno do sistema!";
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Veiculo;
  }

  private String validarNumeroRenavam(final Veiculo veiculo) {
    final Optional<Veiculo> optional = veiculoDAO.findByNumeroRenavam(veiculo.getNumeroRenavam());
    if (optional.isEmpty()) {
      return null;
    }
    return "Número de Renavam indisponível!";
  }
}
