package com.projeto.gestaomultas.strategy;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidarMotorista implements Factory {

  @Autowired private ValidarCpf validarCpf;

  @Autowired private ValidarCnh validarCnh;

  @Override
  public List<Strategy> getListaStrategy() {
    final List<Strategy> strategys = new ArrayList<>();
    strategys.add(validarCpf);
    strategys.add(validarCnh);
    return strategys;
  }

}
