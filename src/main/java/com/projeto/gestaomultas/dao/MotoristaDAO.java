  package com.projeto.gestaomultas.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.LogAplicacao;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.repository.MotoristaRepository;

@Service
public class MotoristaDAO implements DAO {

  @Autowired private MotoristaRepository motoristaRepository;

  @Autowired private LogDAO logDAO;

  @Override
  public String delete(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motoristaRepository.delete(motorista);
    return registrarLog("Exclusão de motorista realizado com sucesso!");
  }

  @Override
  public List<Motorista> find(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    List<Motorista> motoristas = new ArrayList<>();
    if (motorista.getMotoristaId() != null) {
      motoristas.add(findById(motorista.getMotoristaId()));
    } else {
      motoristas = findAll();
    }
    return motoristas;
  }

  @Override
  public List<Motorista> findAll() {
    return motoristaRepository.findAll();
  }

  @Override
  public Motorista findById(final Long motoristaId) {
    final Motorista motorista = motoristaRepository.findById(motoristaId)
        .orElse(new Motorista());
    return motorista;
  }

  public Optional<Motorista> findMotoristaByCnh(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    final Example<Motorista> example = Example.of(
        Motorista.builder()
        .numeroCNH(motorista.getNumeroCNH())
        .build());
    return motoristaRepository.findOne(example);
  }

  public Optional<Motorista> findMotoristaByCpf(final String cpf) {
    final Example<Motorista> example = Example.of(
        Motorista.builder()
        .cpf(cpf)
        .build());
    return motoristaRepository.findOne(example);
  }

  @Override
  public String save(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motorista.setDataCadastro(LocalDate.now());
    motoristaRepository.save(motorista);
    return registrarLog("Cadastro de Motorista realizado com sucesso!");
  }

  @Override
  public String update(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motorista.setDataCadastro(LocalDate.now());
    motoristaRepository.save(motorista);
    return registrarLog("Atualização do Motorista realizado com sucesso!");
  }

  @Override
  public String registrarLog(final String registro) {
    final LogAplicacao log = LogAplicacao.builder().log(registro).build();
    logDAO.save(log);
    return registro;
  }
}
