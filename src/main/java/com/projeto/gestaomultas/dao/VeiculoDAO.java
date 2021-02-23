package com.projeto.gestaomultas.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.LogAplicacao;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.domain.Veiculo;
import com.projeto.gestaomultas.repository.VeiculoRepository;

@Component
public class VeiculoDAO implements DAO {

  @Autowired private VeiculoRepository veiculoRepository;

  @Autowired private MotoristaDAO motoristaDAO;

  @Autowired private LogDAO logDAO;

  @Override
  public String delete(final Domain domain) {
    final Veiculo veiculo = (Veiculo) domain;
    veiculoRepository.delete(veiculo);
    return registrarLog("Exclusão de Veiculo realizado com sucesso!");
  }

  @Override
  public List<Veiculo> find(final Domain domain) {
    final Veiculo veiculo = (Veiculo) domain;
    return veiculo != null ? findByParameter(veiculo) : findAll();
  }

  @Override
  public List<Veiculo> findAll() {
    return veiculoRepository.findAll();
  }

  public List<Veiculo> findByParameter(final Veiculo veiculo) {
    List<Veiculo> veiculos = new ArrayList<>();
    if (veiculo.getVeiculoId() != null) {
      veiculos.add(findById(veiculo.getVeiculoId()));
    } else {
      veiculos = findByMotoristaId(veiculo.getMotoristaId());
    }
    return veiculos;
  }

  public List<Veiculo> findByMotoristaId(final Long motoristaId) {
    final Motorista motorista = motoristaDAO.findById(motoristaId);
    return motorista.getVeiculos();
  }

  @Override
  public Veiculo findById(final Long veiculoId) {
    final Veiculo veiculo = veiculoRepository.findById(veiculoId)
        .orElse(new Veiculo());
    return veiculo;
  }

  public Optional<Veiculo> findByPlaca(final String placa) {
    final Example<Veiculo> example = Example.of(
        Veiculo.builder()
        .placa(placa)
        .build());
    return veiculoRepository.findOne(example);
  }

  public Optional<Veiculo> findByNumeroRenavam(final String numeroRenavam) {
    final Example<Veiculo> example = Example.of(
        Veiculo.builder()
        .numeroRenavam(numeroRenavam)
        .build());
    return veiculoRepository.findOne(example);
  }

  @Override
  public String save(final Domain domain) {
    final Veiculo veiculo = (Veiculo) domain;
    veiculo.setDataCadastro(LocalDate.now());
    veiculoRepository.save(veiculo);
    return registrarLog("Cadastro de Veiculo realizado com sucesso!");
  }

  @Override
  public String update(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String registrarLog(final String registro) {
    final LogAplicacao log = LogAplicacao.builder().log(registro).build();
    logDAO.save(log);
    return registro;
  }
}