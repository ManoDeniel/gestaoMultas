package com.projeto.gestaomultas.domain.dto;

import java.io.Serializable;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MotoristaDTO implements Serializable {

  private static final long serialVersionUID = -7802498865364759703L;

  private Long motoristaId;

  private String cpf;

  private String nome;

  private String sobrenome;

  private String numeroCNH;

  private EnderecoDTO endereco;

  private TelefoneDTO telefone;

  private List<MultaDTO> multas;

  private List<VeiculoDTO> veiculos;
}
