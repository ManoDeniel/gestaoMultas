package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
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
  public List<Domain> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Domain save(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Domain update(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

}
