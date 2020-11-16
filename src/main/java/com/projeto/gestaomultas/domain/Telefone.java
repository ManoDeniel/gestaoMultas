package com.projeto.gestaomultas.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(of = {"telefoneId"})
@Entity
@Table(name = "TELEFONE")
public class Telefone implements Serializable {

  private static final long serialVersionUID = 4280461719379773273L;

  @Id
  @Column(name = "TELEFONE_ID", length = 8)
  private Long telefoneId;

  @Column(name = "NUMERO", length = 15)
  private String numero;

  @Column(name = "TIPO_TELEFONE", length = 20)
  private String tipoTelefone; // enum

}
