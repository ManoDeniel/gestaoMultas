package com.projeto.gestaomultas.domain;

import java.io.Serializable;
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

}
