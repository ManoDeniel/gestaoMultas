  package com.projeto.gestaomultas.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.repository.MotoristaRepository;

@Service
public class MotoristaDAO implements DAO {

  @Autowired private MotoristaRepository motoristaRepository;

  @Autowired private EnderecoDAO enderecoDAO;

  @Autowired private TelefoneDAO telefoneDAO;

  @Override
  public String delete(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motoristaRepository.delete(motorista);
    return "Motorista deletado com sucesso!";
  }

  @Override
  public List<Motorista> find(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    return motorista.getMotoristaId() != null 
        ? findById(motorista.getMotoristaId())
            : findAll();
  }

  @Override
  public List<Motorista> findAll() {
    return motoristaRepository.findAll();
  }

  @Override
  public List<Motorista> findById(final Long motoristaId) {
    final List<Motorista> motoristas = new ArrayList<>();
    final Motorista motorista = motoristaRepository.findById(motoristaId)
        .orElse(new Motorista());
    motoristas.add(motorista);
    return motoristas;
  }

  public Optional<Motorista> findMotoristaByCpf(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    final String cpf = motorista.getCpf();
    final Example<Motorista> example = Example.of(Motorista.builder().cpf(cpf).build());
    return motoristaRepository.findOne(example);
  }

  @Override
  public String save(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motoristaRepository.save(motorista);
    return "Cadastro de Motorista realizado com sucesso!";
  }

  @Override
  public String update(final Domain domain) {
    final Motorista motorista = (Motorista) domain;
    motorista.getEndereco().setMotoristaId(motorista.getMotoristaId());
    motorista.getTelefone().setMotoristaId(motorista.getMotoristaId());
    motoristaRepository.save(motorista);
    return "Motorista atualizado com sucesso!";
  }
}
