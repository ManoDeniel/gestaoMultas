package com.projeto.gestaomultas.dao;

import java.util.List;
import com.projeto.gestaomultas.domain.Domain;

public interface DAO {

  public String delete(final Domain domain);

  @SuppressWarnings("rawtypes")
  public List findAll();

  public Domain save(final Domain domain);

  public Domain update(final Domain domain);

}
