package com.projeto.gestaomultas.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.gestaomultas.domain.dto.MotoristaDTO;
import com.projeto.gestaomultas.service.MotoristaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/")
@Api(
    value = "multa-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "multa-controller")
public class MotoristaController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private MotoristaService motoristaService;

  @GetMapping("/motoristas")
  @ApiOperation(
      value = "Retorna uma lista de todos os motoristas cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MotoristaDTO> findAll() {
    return motoristaService.findAll()
        .stream().map(motorista -> modelMapper.map(motorista, MotoristaDTO.class))
        .collect(Collectors.toList());
  }
}
