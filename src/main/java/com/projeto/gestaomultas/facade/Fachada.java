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
import com.projeto.gestaomultas.strategy.ValidarCNH;
import com.projeto.gestaomultas.strategy.ValidarCPF;
import com.projeto.gestaomultas.strategy.ValidarNumeroInfracao;
import com.projeto.gestaomultas.strategy.ValidarNumeroRenavam;
import com.projeto.gestaomultas.strategy.ValidarPlacaVeiculo;

@Component
public class Fachada {

  @Autowired private MotoristaDAO motoristaDAO;

  @Autowired private MultaDAO multaDAO;

  @Autowired private VeiculoDAO veiculoDAO;

  @Autowired private ValidarCPF validarCPF;

  @Autowired private ValidarCNH validarCNH;

  @Autowired private ValidarNumeroInfracao validarNumeroInfracao;

  @Autowired private ValidarPlacaVeiculo validarPlacaVeiculo;

  @Autowired private ValidarNumeroRenavam validarNumeroRenavam;

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

    final List<Strategy> veiculoStrategys = new ArrayList<>();
    veiculoStrategys.add(validarPlacaVeiculo);
    veiculoStrategys.add(validarNumeroRenavam);

    final List<Strategy> multaStrategys = new ArrayList<>();
    multaStrategys.add(validarNumeroInfracao);

    final List<Strategy> motoristaStrategys = new ArrayList<>();
    motoristaStrategys.add(validarCPF);
    motoristaStrategys.add(validarCNH);

    strategys.put(Veiculo.class.getName(), veiculoStrategys);
    strategys.put(Multa.class.getName(), multaStrategys);
    strategys.put(Motorista.class.getName(), motoristaStrategys);
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
    if (strategys != null) {
      for (final Strategy strategy : strategys) {
        logErro = strategy.processar(domain);
        if (logErro != null) {
          return logErro;
        }
      }
    }
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.save(domain);
  }

  public String update(final Domain domain) {
    configMaps();
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.update(domain);
  }
}
