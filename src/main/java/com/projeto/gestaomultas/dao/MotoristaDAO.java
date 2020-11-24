package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.repository.MotoristaRepository;

@Component
public class MotoristaDAO implements DAO {

  @Autowired private MotoristaRepository motoristaRepository;

  @Override
  public Domain save(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    return motoristaRepository.save(motorista);
  }

  @Override
  public String delete(final Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Domain update(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Domain> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
