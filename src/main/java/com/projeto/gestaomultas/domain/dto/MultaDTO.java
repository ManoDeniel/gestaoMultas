package com.projeto.gestaomultas.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MultaDTO implements Serializable {

  private static final long serialVersionUID = -894187545536120236L;

  private Long multaId;

  private String numeroInfracao;

  private String tipoInfracao; // enum

  private String descricaoInfracao;

  private String orgaoAutuador; // enum

  private BigDecimal valor;

  private Long pontuacao;

  private LocalDate dataEmissao;

  private LocalDate dataVencimento;

}
