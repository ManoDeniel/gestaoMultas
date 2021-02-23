package com.projeto.gestaomultas.domain.dto;

import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class VeiculoDTO implements Serializable {

  private static final long serialVersionUID = 5760815957377493541L;

  private Long veiculoId;

  private String marca;

  private String modelo;

  private String anoFabricacao;

  private String cor;

  private String placa;

  private String numeroRenavam;

  private Long motoristaId;
}
