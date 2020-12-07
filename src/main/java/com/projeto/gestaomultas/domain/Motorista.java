package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(of = {"motoristaId"}, callSuper=false)
@Entity
@Table(name = "MOTORISTA")
public class Motorista extends Domain implements Serializable {

  private static final long serialVersionUID = -3720446385799226119L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_MOTORISTA")
  @SequenceGenerator(
      name = "SEQ_MOTORISTA", 
      sequenceName = "SEQ_MOTORISTA",
      allocationSize = 1)
  @Id
  @Column(name = "MOTORISTA_ID", length = 8)
  private Long motoristaId;

  @Column(name = "CPF", length = 14)
  private String cpf;

  @Column(name = "NOME", length = 50)
  private String nome;

  @Column(name = "SOBRENOME", length = 50)
  private String sobrenome;

  @Column(name = "NUMERO_CNH", length = 11)
  private String numeroCNH;

  @OneToMany
  @JoinColumn(name = "MULTA_ID")
  private List<Multa> multas;

  @OneToMany
  @JoinColumn(name = "VEICULO_ID")
  private List<Veiculo> veiculos;
  
  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "ENDERECO_ID")
  private Endereco endereco;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "TELEFONE_ID")
  private Telefone telefone;
}
