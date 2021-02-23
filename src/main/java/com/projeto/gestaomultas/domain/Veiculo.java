package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(of = {"veiculoId"}, callSuper=false)
@Entity
@Table(name = "VEICULO")
public class Veiculo extends Domain implements Serializable {

  private static final long serialVersionUID = -6831729678352353721L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_VEICULO")
  @SequenceGenerator(
      name = "SEQ_VEICULO", 
      sequenceName = "SEQ_VEICULO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
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

  @CreationTimestamp
  @Column(name = "DATA_CADASTRO")
  private LocalDate dataCadastro;

  @Column(name = "MOTORISTA_ID", insertable = false, updatable = false)
  private Long motoristaId;

  @ManyToOne
  @JoinColumn(name = "MOTORISTA_ID", referencedColumnName = "ID")
  private Motorista motorista;

  @OneToMany(mappedBy = "veiculo")
  private List<Multa> multas;
}
