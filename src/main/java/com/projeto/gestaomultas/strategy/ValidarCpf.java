package com.projeto.gestaomultas.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.dao.MotoristaDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;

@Component
public class ValidarCpf implements Strategy {

  @Autowired private MotoristaDAO motoristaDAO;

  @Override
  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Motorista motorista = (Motorista) domain;
      return verificarCpf(motorista);
    }
    return "Erro interno do sistema!";
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Motorista;
  }

  private String verificarCpf(final Motorista motorista) {
    final Optional<Motorista> motoristaCpf = motoristaDAO.findMotoristaByCpf(motorista);
    if (motoristaCpf.isEmpty()) {
      return validarNumerosCpf(getNumeros(motorista.getCpf()));
    }
    return "O CPF digitado está indisponível!";
  }

  private String getNumeros(final String cpf) {
    return cpf.replaceAll("\\D", "");
  }

  private String validarNumerosCpf(final String numerosCpf) {
    if (!verificarEmPadroes(numerosCpf)) {
      if (validarPrimeiroDigito(numerosCpf)) {
        if (validarSegundoDigito(numerosCpf)) {
          return null;
        }
      }
    }
    return "CPF inválido!";
  }
  
  private Boolean validarPrimeiroDigito(final String numerosCpf) {
    int soma = 0, resultado, digito, peso = 10;
    for (int posicaoDigito = 0; posicaoDigito < 9; posicaoDigito++) {
      digito = (int)(numerosCpf.charAt(posicaoDigito) - 48);
      soma = soma + (digito * peso);
      peso--;
    }
    resultado = 11 - (soma % 11);
    return obterDigitoVerificador(resultado) == numerosCpf.charAt(9);
  }

  private Boolean validarSegundoDigito(final String numerosCpf) {
    int soma = 0, resultado, digito, peso = 11;
    for (int posicaoDigito = 0; posicaoDigito < 10; posicaoDigito++) {
      digito = (int)(numerosCpf.charAt(posicaoDigito) - 48);
      soma = soma + (digito * peso);
      peso--;
    }
    resultado = 11 - (soma % 11);
    return obterDigitoVerificador(resultado) == numerosCpf.charAt(10);
  }

  private char obterDigitoVerificador(int resultado) {
    return (resultado == 10) || (resultado == 11) ? '0' : (char)(resultado + 48);
  }

  private Boolean verificarEmPadroes(final String numerosCpf) {
    return numerosCpf.equals("00000000000") || 
        numerosCpf.equals("11111111111") || 
        numerosCpf.equals("22222222222") || 
        numerosCpf.equals("33333333333") || 
        numerosCpf.equals("44444444444") || 
        numerosCpf.equals("55555555555") || 
        numerosCpf.equals("66666666666") || 
        numerosCpf.equals("77777777777") || 
        numerosCpf.equals("88888888888") || 
        numerosCpf.equals("99999999999") || 
        (numerosCpf.length() != 11);
  }
}
