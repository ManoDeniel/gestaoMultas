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
import com.projeto.gestaomultas.domain.Multa;
import com.projeto.gestaomultas.repository.MultaRepository;

@Component
public class MultaDAO implements DAO {

  @Autowired private MultaRepository multaRepository;

  @Autowired private MotoristaDAO motoristaDAO;

  @Autowired private LogDAO logDAO;

  @Override
  public String delete(final Domain domain) {
    final Multa multa = (Multa) domain;
    multaRepository.delete(multa);
    return registrarLog("Exclusão de Multa realizado com sucesso!");
  }

  @Override
  public List<Multa> find(final Domain domain) {
    final Multa multa = (Multa) domain;
    return multa != null ? findByParameter(multa) : findAll();
  }

  @Override
  public List<Multa> findAll() {
    return multaRepository.findAll();
  }

  public List<Multa> findByParameter(final Multa multa) {
    List<Multa> multas = new ArrayList<>();
    if (multa.getMultaId() != null) {
      multas.add(findById(multa.getMultaId()));
    } else {
      multas = findByMotoristaId(multa.getMotoristaId());
    }
    return multas;
  }

  public List<Multa> findByMotoristaId(final Long motoristaId) {
    final Motorista motorista = motoristaDAO.findById(motoristaId);
    return motorista.getMultas();
  }

  public Multa findById(final Long multaId) {
    final Multa multa = multaRepository.findById(multaId)
        .orElse(new Multa());
    return multa;
  }

  public Optional<Multa> findByNumeroInfracao(final String numeroInfracao) {
    final Example<Multa> example = Example.of(
        Multa.builder()
        .numeroInfracao(numeroInfracao)
        .build());
    return multaRepository.findOne(example);
  }

  @Override
  public String save(final Domain domain) {
    final Multa multa = (Multa) domain;
    multa.setDataCadastro(LocalDate.now());
    multaRepository.save(multa);
    return registrarLog("Cadastro de Multa realizado com sucesso!");
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
