package com.projeto.gestaomultas.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.gestaomultas.command.FindCommand;
import com.projeto.gestaomultas.domain.Multa;
import com.projeto.gestaomultas.domain.dto.MultaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/multa")
@Api(
    value = "multa-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "multa-controller")
public class MultaController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private FindCommand findCommand;

  @GetMapping("/multas")
  @ApiOperation(
      value = "Retorna uma lista de todos os multas cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MultaDTO> findAll(@RequestBody final MultaDTO multaDTO) {
    final Multa multaInput = modelMapper.map(multaDTO, Multa.class);
    return findCommand.executar(multaInput)
        .stream().map(multa -> modelMapper.map(multa, MultaDTO.class))
        .collect(Collectors.toList());
  }
}
