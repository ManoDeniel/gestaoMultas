package com.projeto.gestaomultas.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.dao.DAO;
import com.projeto.gestaomultas.dao.MotoristaDAO;
import com.projeto.gestaomultas.dao.MultaDAO;
import com.projeto.gestaomultas.dao.VeiculoDAO;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.domain.Multa;
import com.projeto.gestaomultas.domain.Veiculo;
import com.projeto.gestaomultas.strategy.Strategy;
import com.projeto.gestaomultas.strategy.ValidarCpf;

@Component
public class Fachada {

  @Autowired private MotoristaDAO motoristaDAO;

  @Autowired private MultaDAO multaDAO;

  @Autowired private VeiculoDAO veiculoDAO;

  @Autowired private ValidarCpf validarcpf;

  protected Map<String, DAO> allDao;

  protected Map<String, List<Strategy>> allStrategy;

  public Map<String, DAO> loadDao() {
    final Map<String, DAO> daos = new HashMap<>();
    daos.put(Motorista.class.getName(), motoristaDAO);
    daos.put(Multa.class.getName(), multaDAO);
    daos.put(Veiculo.class.getName(), veiculoDAO);
    return daos;
  }

  public Map<String, List<Strategy>> loadStrategy() {
    final Map<String, List<Strategy>> strategys = new HashMap<>();
    final List<Strategy> motoristaStrategy = new ArrayList<>();
    motoristaStrategy.add(validarcpf);
    strategys.put(Motorista.class.getName(), motoristaStrategy);
    return strategys;
  }

  private void configMaps() {
    allDao = loadDao();
    allStrategy = loadStrategy();
  }

  public String delete(final Domain domain) {
    configMaps();
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.delete(domain);
  }

  public List<? extends Domain> find(final Domain domain) {
    configMaps();
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.find(domain);
  }

  public String save(final Domain domain) {
    configMaps();
    String logErro = null;
    final List<Strategy> strategys = allStrategy.get(domain.getClass().getName());
    for (final Strategy strategy : strategys) {
      logErro = strategy.processar(domain);
    }
    if (logErro == null) {
        final DAO dao = allDao.get(domain.getClass().getName());
        return dao.save(domain);
    }
    return logErro;
  }

  public String update(final Domain domain) {
    configMaps();
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.update(domain);
  }
}
