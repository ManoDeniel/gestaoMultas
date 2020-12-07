package com.projeto.gestaomultas.dao;

import java.util.List;
import com.projeto.gestaomultas.domain.Domain;

public interface DAO {

  public String delete(final Domain domain);

  public List<? extends Domain> find(final Domain domain);

  public List<? extends Domain> findAll();

  public List<? extends Domain> findById(final Long id);

  public String save(final Domain domain);

  public String update(final Domain domain);

}
