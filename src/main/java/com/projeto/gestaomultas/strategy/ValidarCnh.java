package com.projeto.gestaomultas.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.dao.MotoristaDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;

@Component
public class ValidarCNH implements Strategy {

  @Autowired private MotoristaDAO motoristaDAO;

  @Override
  public String processar(final Domain domain) {
    if(verificarInstancia(domain)) {
      final Motorista motorista = (Motorista) domain;
      return validarCNH(motorista);
    } else {
      return "Erro interno do sistema!";
    }
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Motorista;
  }

  private String validarCNH(final Motorista motorista) {
    final Optional<Motorista> optional = motoristaDAO.findMotoristaByCnh(motorista);
    if (optional.isEmpty()) {
      return verificarTamanho(motorista.getNumeroCNH());
    }
    return "Número de CNH indisponível!";
  }

  private String verificarTamanho(final String numeroCNH) {
    return numeroCNH.length() != 11 
        ? "Número de CNH deve possuir 11 dígitos!"
            : null;
  }
}
