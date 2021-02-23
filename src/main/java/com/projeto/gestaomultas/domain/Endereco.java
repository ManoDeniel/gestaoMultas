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
@lombok.EqualsAndHashCode(of = {"enderecoId"}, callSuper=false)
@Entity
@Table(name = "ENDERECO")
public class Endereco extends Domain implements Serializable {

  private static final long serialVersionUID = 2032636495971516732L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_ENDERECO")
  @SequenceGenerator(
      name = "SEQ_ENDERECO", 
      sequenceName = "SEQ_ENDERECO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8)
  private Long enderecoId;

  @Column(name = "RUA", length = 40)
  private String rua;

  @Column(name = "NUMERO", length = 10)
  private String numero;

  @Column(name = "TIPO_LOGRADOURO", length = 30)
  private String tipoLogradouro;

  @Column(name = "BAIRRO", length = 100)
  private String bairro;

  @Column(name = "CIDADE", length = 100)
  private String cidade;

  @Column(name = "ESTADO", length = 30)
  private String estado;

  @Column(name = "CEP", length = 8)
  private String cep;

  @CreationTimestamp
  @Column(name = "DATA_CADASTRO")
  private LocalDate dataCadastro;
}
