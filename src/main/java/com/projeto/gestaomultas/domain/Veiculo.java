package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(of = {"veiculoId"})
@Entity
@Table(name = "VEICULO")
public class Veiculo implements Serializable {

  private static final long serialVersionUID = -6831729678352353721L;

  @Id
  @Column(name = "VEICULO_ID", length = 8, nullable = false, updatable = false)
  private Long veiculoId;

  @Column(name = "MARCA")
  private String marca;

  @Column(name = "MODELO")
  private String modelo;

  @Column(name = "ANO_FABRICACAO")
  private String anoFabricacao;

  @Column(name = "COR")
  private String cor;

  @Column(name = "PLACA")
  private String placa;

  @Column(name = "NUMERO_RENAVAM")
  private String numeroRenavam;
}
