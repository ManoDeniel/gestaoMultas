package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Multa;
import com.projeto.gestaomultas.repository.MultaRepository;

@Component
public class MultaDAO implements DAO {

  @Autowired private MultaRepository multaRepository;

  @Override
  public String delete(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Multa> find(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Multa> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Multa> findById(final Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String save(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String update(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

}
