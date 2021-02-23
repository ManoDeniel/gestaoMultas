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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.gestaomultas.command.DeleteCommand;
import com.projeto.gestaomultas.command.FindCommand;
import com.projeto.gestaomultas.command.SaveCommand;
import com.projeto.gestaomultas.domain.Domain;
import com.projeto.gestaomultas.domain.Multa;
import com.projeto.gestaomultas.domain.dto.MultaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/multa")
@CrossOrigin
@Api(
    value = "multa-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "multa-controller")
public class MultaController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @GetMapping("/multas/{multaId}")
  @ApiOperation(
      value = "Retorna uma multa por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public MultaDTO findById(@PathVariable(name = "multaId") final Long multaId) {
    final Multa multaInput = Multa.builder().multaId(multaId).build();
    final List<? extends Domain> multas = findCommand.executar(multaInput);
    return modelMapper.map(multas.get(0), MultaDTO.class);
  }

  @GetMapping("/multas/motorista/{motoristaId}")
  @ApiOperation(
      value = "Retora uma lista de multas por motoristaId",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MultaDTO> findAllMultaByMotorista(
      @PathVariable(name = "motoristaId") final Long motoristaId) {
    final Multa multaInput = Multa.builder().motoristaId(motoristaId).build();
    return findCommand.executar(multaInput)
        .stream().map(multa -> modelMapper.map(multa, MultaDTO.class))
        .collect(Collectors.toList());
  }

  @PostMapping("/multas")
  @ApiOperation(
      value = "Realiza a persistencia de uma multa",
          produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody final MultaDTO multaDTO) {
    final Multa multaInput = modelMapper.map(multaDTO, Multa.class);
    return saveCommand.executar(multaInput);
  }

  @DeleteMapping("/multas/{multaId}")
  @ApiOperation(
      value = "Faz a exclusão de um multa por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "multaId") final Long multaId) {
    final Multa multa = Multa.builder().multaId(multaId).build();
    return deleteCommand.executar(multa);
  }

}
