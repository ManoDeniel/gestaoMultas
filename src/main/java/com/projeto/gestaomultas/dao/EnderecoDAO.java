package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Endereco;
import com.projeto.gestaomultas.repository.EnderecoRepository;

@Service
public class EnderecoDAO implements DAO {

  @Autowired private EnderecoRepository enderecoRepository;

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
    final Endereco endereco = (Endereco) domain;
    enderecoRepository.save(endereco);
    return null;
  }

  @Override
  public String update(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

}
