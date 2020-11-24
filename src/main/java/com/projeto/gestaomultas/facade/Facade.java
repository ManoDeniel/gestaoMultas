package com.projeto.gestaomultas.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.dao.MotoristaDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.strategy.FactoryStrategy;
import com.projeto.gestaomultas.strategy.Strategy;

@Component
public class Facade {

  @Autowired private MotoristaDAO motoristaDAO;

  @Autowired private FactoryStrategy factoryStrategy;

  public Domain salvar(final Domain domain) {
    final String className = domain.getClass().getSimpleName().toLowerCase();
    final List<Strategy> strategys = factoryStrategy.getStrategys(className);
    for (final Strategy strategy : strategys) {
      strategy.processar(domain);
    }
    return motoristaDAO.save(domain);
  }

}
