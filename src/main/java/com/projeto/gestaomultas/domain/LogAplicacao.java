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
@lombok.EqualsAndHashCode(of = {"logId"}, callSuper=false)
@Entity
@Table(name = "LOG_APLICACAO")
public class LogAplicacao extends Domain implements Serializable {

  private static final long serialVersionUID = -7722872034163467732L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_LOG")
  @SequenceGenerator(
      name = "SEQ_LOG", 
      sequenceName = "SEQ_LOG",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8)
  private Long logId;

  @Column(name = "LOG", length = 200)
  private String log;

  @CreationTimestamp
  @Column(name = "DATA_CADASTRO")
  private LocalDate dataCadastro;
}
