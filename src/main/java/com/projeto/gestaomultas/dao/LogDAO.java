package com.projeto.gestaomultas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.LogAplicacao;
import com.projeto.gestaomultas.repository.LogRepository;

@Component
public class LogDAO implements DAO {

  @Autowired private LogRepository logRepository;

  @Override
  public String save(final Domain domain) {
    final LogAplicacao log = (LogAplicacao) domain;
    logRepository.save(log);
    return "Log registrado!";
  }

  @Override
  public String delete(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> find(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Domain findById(final Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String update(final Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
