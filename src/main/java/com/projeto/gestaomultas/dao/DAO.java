package com.projeto.gestaomultas.dao;

import java.util.List;
import com.projeto.gestaomultas.domain.Domain;

public interface DAO {

  public Domain save(final Domain domain);

  public String delete(final Long id);

  public Domain update(final Domain domain);

  public List<Domain> findAll();

}
