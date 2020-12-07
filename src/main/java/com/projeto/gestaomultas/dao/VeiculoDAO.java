package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Veiculo;
import com.projeto.gestaomultas.repository.VeiculoRepository;

@Component
public class VeiculoDAO implements DAO {

  @Autowired private VeiculoRepository vaiculoRepository;

  @Override
  public String delete(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Veiculo> find(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Veiculo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Veiculo> findById(final Long veiculoId) {
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