package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

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
  @Column(name = "ID", length = 8)
  private Long multaId;

  @Column(name = "NUMERO_INFRACAO", length = 4)
  private String numeroInfracao;

  @Column(name = "TIPO_INFRACAO", length = 30)
  private String tipoInfracao;

  @Column(name = "DESCRICAO_INFRACAO", length = 200)
  private String descricaoInfracao;

  @Column(name = "ORGAO_AUTUADOR", length = 50)
  private String orgaoAutuador;

  @Column(name = "VALOR")
  private BigDecimal valor;

  @Column(name = "PONTUACAO", length = 3)
  private Long pontuacao;

  @Column(name = "DATA_EMISSAO")
  private LocalDate dataEmissao;

  @Column(name = "DATA_VENCIMENTO")
  private LocalDate dataVencimento;

  @CreationTimestamp
  @Column(name = "DATA_CADASTRO")
  private LocalDate dataCadastro;

  @Column(name = "MOTORISTA_ID", insertable = false, updatable = false)
  private Long motoristaId;

  @Column(name = "VEICULO_ID", insertable = false, updatable = false)
  private Long veiculoId;

  @ManyToOne
  @JoinColumn(name = "MOTORISTA_ID", referencedColumnName = "ID")
  private Motorista motorista;

  @ManyToOne
  @JoinColumn(name = "VEICULO_ID", referencedColumnName = "ID")
  private Veiculo veiculo;
}
