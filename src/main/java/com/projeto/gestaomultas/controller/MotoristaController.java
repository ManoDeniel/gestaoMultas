package com.projeto.gestaomultas.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.gestaomultas.command.DeleteCommand;
import com.projeto.gestaomultas.command.FindCommand;
import com.projeto.gestaomultas.command.SaveCommand;
import com.projeto.gestaomultas.command.UpdateCommand;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.domain.dto.MotoristaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/motorista")
@CrossOrigin
@Api(
    value = "motorista-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "motorista-controller")
public class MotoristaController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @Autowired private UpdateCommand updateCommand;
  
  @GetMapping("/motoristas/{motoristaId}")
  @ApiOperation(
      value = "Retorna um motorista por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public MotoristaDTO findById(@PathVariable(name = "motoristaId") final Long motoristaId) {
    final Motorista motoristaInput = Motorista.builder().motoristaId(motoristaId).build();
    final List<? extends Domain> executar = findCommand.executar(motoristaInput);
    return modelMapper.map(executar.get(0), MotoristaDTO.class);
  }

  @GetMapping("/motoristas")
  @ApiOperation(
      value = "Retorna uma lista de todos os motoristas cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MotoristaDTO> findAll() {
    final Motorista motoristaInput = new Motorista();
    return findCommand.executar(motoristaInput)
        .stream().map(motorista -> modelMapper.map(motorista, MotoristaDTO.class))
        .collect(Collectors.toList());
  }

  @PostMapping("/motoristas")
  @ApiOperation(
      value = "Realiza a persistencia de um motorista",
          produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody final MotoristaDTO motoristaDTO) {
    final Motorista motoristaInput = modelMapper.map(motoristaDTO, Motorista.class);
    return saveCommand.executar(motoristaInput);
  }

  @PutMapping("/motoristas/{motoristaId}")
  @ApiOperation(
      value = "Atualiza as informações de um motorista atráves de um id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String update(
      @RequestBody final MotoristaDTO motoristaDTO,
      @PathVariable(name = "motoristaId") final Long motoristaId) {
    final Motorista motoristaInput = modelMapper.map(motoristaDTO, Motorista.class);
    motoristaInput.setMotoristaId(motoristaId);
    return updateCommand.executar(motoristaInput);
  }

  @DeleteMapping("/motoristas/{motoristaId}")
  @ApiOperation(
      value = "Faz a exclusão de um motorista por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "motoristaId") final Long motoristaId) {
    final Motorista motorista = Motorista.builder().motoristaId(motoristaId).build();
    return deleteCommand.executar(motorista);
  }
}
