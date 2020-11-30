package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(of = {"multaId"}, callSuper=false)
@Entity
@Table(name = "MULTA")
public class Multa extends Domain implements Serializable {

  private static final long serialVersionUID = 8366733246771203194L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_MULTA")
  @SequenceGenerator(
      name = "SEQ_MULTA", 
      sequenceName = "SEQ_MULTA",
      allocationSize = 1)
  @Id
  @Column(name = "MULTA_ID", length = 8)
  private Long multaId;

  @Column(name = "NUMERO_INFRACAO", length = 4)
  private String numeroInfracao;

  @Column(name = "TIPO_INFRACAO", length = 30)
  private String tipoInfracao; // enum

  @Column(name = "DESCRICAO_INFRACAO", length = 200)
  private String descricaoInfracao;

  @Column(name = "ORGAO_AUTUADOR", length = 50)
  private String orgaoAutuador; // enum

  @Column(name = "VALOR")
  private BigDecimal valor;

  @Column(name = "PONTUACAO", length = 3)
  private Long pontuacao;

  @Column(name = "DATA_EMISSAO")
  private LocalDate dataEmissao;

  @Column(name = "DATA_VENCIMENTO")
  private LocalDate dataVencimento;

}
