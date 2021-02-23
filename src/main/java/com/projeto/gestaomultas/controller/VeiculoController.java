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
import com.projeto.gestaomultas.domain.Veiculo;
import com.projeto.gestaomultas.domain.dto.VeiculoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/veiculo")
@CrossOrigin
@Api(
    value = "veiculo-controller",
    produces = MediaType.APPLICATION_JSON_VALUE,
    tags = "veiculo-controller")
public class VeiculoController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @GetMapping("/veiculos/{veiculoId}")
  @ApiOperation(
      value = "Retorna um veiculo por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public VeiculoDTO findById(
      @PathVariable(name = "veiculoId") final Long veiculoId) {
    final Veiculo veiculoInput = Veiculo.builder().veiculoId(veiculoId).build();
    final List<? extends Domain> veiculos = findCommand.executar(veiculoInput);
    return modelMapper.map(veiculos.get(0), VeiculoDTO.class);
  }

  @GetMapping("/veiculos/motorista/{motoristaId}")
  @ApiOperation(
      value = "Retora uma lista de veiculos por motoristaId",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<VeiculoDTO> findAllVeiculoByMotorista(
      @PathVariable(name = "motoristaId") final Long motoristaId) {
    final Veiculo veiculoInput = Veiculo.builder().motoristaId(motoristaId).build();
    return findCommand.executar(veiculoInput)
        .stream().map(veiculo -> modelMapper.map(veiculo, VeiculoDTO.class))
        .collect(Collectors.toList());
  }

  @PostMapping("/veiculos")
  @ApiOperation(
      value = "Realiza a persistencia de um veiculo",
          produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody final VeiculoDTO veiculoDTO) {
    final Veiculo veiculoInput = modelMapper.map(veiculoDTO, Veiculo.class);
    return saveCommand.executar(veiculoInput);
  }

  @DeleteMapping("/veiculos/{veiculoId}")
  @ApiOperation(
      value = "Faz a exclusão de um veiculo por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "veiculoId") final Long veiculoId) {
    final Veiculo veiculo = Veiculo.builder().veiculoId(veiculoId).build();
    return deleteCommand.executar(veiculo);
  }
}
