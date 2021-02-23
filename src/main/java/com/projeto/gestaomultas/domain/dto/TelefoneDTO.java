package com.projeto.gestaomultas.domain.dto;

import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class TelefoneDTO implements Serializable {

  private static final long serialVersionUID = -3026983541113437747L;

  private Long telefoneId;

  private String numero;

  private String tipoTelefone;
}
