package com.projeto.gestaomultas.strategy;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryStrategy {

  @Autowired private ValidarMotorista validarMotorista;

  public List<Strategy> getStrategys(final String className) {
    final Factory factory = getFactory(className);
    return factory.getListaStrategy();
  }

  private Factory getFactory(final String className) {
    switch (className) {
      case "motorista": return validarMotorista;
//     TODO case "veiculo": return validarVeiculo;
      default:
        return null;
    }
  }
}
