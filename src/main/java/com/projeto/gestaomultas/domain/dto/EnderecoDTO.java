package com.projeto.gestaomultas.domain.dto;

import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class EnderecoDTO implements Serializable {

  private static final long serialVersionUID = -4211682000812140563L;

  private Long enderecoId;

  private String rua;

  private String numero;

  private String tipoLogradouro;

  private String bairro;

  private String cidade;

  private String estado;

  private String cep;
}
