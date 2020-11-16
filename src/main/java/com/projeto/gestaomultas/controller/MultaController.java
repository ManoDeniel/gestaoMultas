package com.projeto.gestaomultas.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.gestaomultas.domain.dto.MultaDTO;
import com.projeto.gestaomultas.service.MultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/multa")
@Api(
    value = "multa-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "multa-controller")
public class MultaController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private MultaService multaService;

  @GetMapping("/multas")
  @ApiOperation(
      value = "Retorna uma lista de todos os multas cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MultaDTO> findAll() {
    return multaService.findAll()
        .stream().map(multa -> modelMapper.map(multa, MultaDTO.class))
        .collect(Collectors.toList());
  }
}
