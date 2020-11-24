package com.projeto.gestaomultas.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.gestaomultas.domain.Motorista;
import com.projeto.gestaomultas.domain.dto.MotoristaDTO;
import com.projeto.gestaomultas.facade.Facade;
import com.projeto.gestaomultas.service.MotoristaService;
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

  @Autowired private MotoristaService motoristaService;

  @Autowired private Facade facade;

  @GetMapping("/motoristas")
  @ApiOperation(
      value = "Retorna uma lista de todos os motoristas cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MotoristaDTO> findAll() {
    return motoristaService.findAll()
        .stream().map(motorista -> modelMapper.map(motorista, MotoristaDTO.class))
        .collect(Collectors.toList());
  }

  @PostMapping("/motoristas")
  @ApiOperation(
      value = "Realiza a persistencia de um motorista",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public MotoristaDTO save(@RequestBody final MotoristaDTO motoristaDTO) {
    final Motorista motoristaInput = modelMapper.map(motoristaDTO, Motorista.class);
    final Motorista motoristaOutput = (Motorista) facade.salvar(motoristaInput);
    return modelMapper.map(motoristaOutput, MotoristaDTO.class);
  }
}
