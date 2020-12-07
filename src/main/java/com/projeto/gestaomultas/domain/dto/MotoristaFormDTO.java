package com.projeto.gestaomultas.domain.dto;

import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MotoristaFormDTO implements Serializable {

  private static final long serialVersionUID = -6286564917609710052L;

  private String cpf;

  private String nome;

  private String sobrenome;

  private String numeroCNH;

  private String rua;

  private String numeroEndereco;

  private String logradouro;

  private String bairro;

  private String cidade;

  private String estado;

  private String cep;

  private String numeroTelefone;

  private String tipoTelefone;

}
