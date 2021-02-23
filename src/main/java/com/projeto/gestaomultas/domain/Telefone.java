package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(of = {"telefoneId"}, callSuper=false)
@Entity
@Table(name = "TELEFONE")
public class Telefone extends Domain implements Serializable {

  private static final long serialVersionUID = 4280461719379773273L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_TELEFONE")
  @SequenceGenerator(
      name = "SEQ_TELEFONE", 
      sequenceName = "SEQ_TELEFONE",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8)
  private Long telefoneId;

  @Column(name = "NUMERO", length = 15)
  private String numero;

  @Column(name = "TIPO_TELEFONE", length = 20)
  private String tipoTelefone;

  @CreationTimestamp
  @Column(name = "DATA_CADASTRO")
  private LocalDate dataCadastro;
}
