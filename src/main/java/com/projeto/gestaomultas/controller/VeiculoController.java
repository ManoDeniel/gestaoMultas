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
import com.projeto.gestaomultas.domain.Veiculo;
import com.projeto.gestaomultas.domain.dto.VeiculoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/veiculo")
@Api(
    value = "veiculo-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "veiculo-controller")
public class VeiculoController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private FindCommand findCommand;

  @GetMapping("/veiculos")
  @ApiOperation(
      value = "Retorna uma lista de todos os veiculos cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<VeiculoDTO> findAll(@RequestBody final VeiculoDTO veiculoDTO) {
    final Veiculo veiculoInput = modelMapper.map(veiculoDTO, Veiculo.class);
    return findCommand.executar(veiculoInput)
        .stream().map(veiculo -> modelMapper.map(veiculo, VeiculoDTO.class))
        .collect(Collectors.toList());
  }
}
