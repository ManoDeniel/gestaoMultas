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

  @Autowired
  public Fachada() {
    allDao = loadDao();
    allStrategy = loadStrategy();
  }

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

  public Domain delete(final Domain domain) {
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.save(domain);
  }

  public List<Domain> find(final Domain domain) {
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.findAll();
  }

  public Domain save(final Domain domain) {
    final List<Strategy> strategys = allStrategy.get(domain.getClass().getName());
    strategys.stream().map(strategy -> strategy.processar(domain));
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.save(domain);
  }

  public Domain update(final Domain domain) {
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.update(domain);
  }
}
