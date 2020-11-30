package com.projeto.gestaomultas.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.repository.MotoristaRepository;

@Component
public class MotoristaDAO implements DAO {

  @Autowired private MotoristaRepository motoristaRepository;

  @Override
  public String delete(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motoristaRepository.delete(motorista);
    return null;
  }

  @Override
  public List<Motorista> findAll() {
    return motoristaRepository.findAll();
  }

  public Optional<Motorista> findMotoristaByCpf(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    final String cpf = motorista.getCpf();
    final Example<Motorista> example = Example.of(Motorista.builder().cpf(cpf).build());
    return motoristaRepository.findOne(example);
  }

  @Override
  public Domain save(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    return motoristaRepository.save(motorista);
  }

  @Override
  public Domain update(final Domain domain) {
    return save(domain);
  }
}
