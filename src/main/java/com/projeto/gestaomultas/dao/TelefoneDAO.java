package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Telefone;
import com.projeto.gestaomultas.repository.TelefoneRepository;

@Service
public class TelefoneDAO implements DAO {

  @Autowired private TelefoneRepository telefoneRepository;

  @Override
  public String delete(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> find(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String save(final Domain domain) {
    final Telefone telefone = (Telefone) domain;
    telefoneRepository.save(telefone);
    return null;
  }

  @Override
  public String update(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

}
