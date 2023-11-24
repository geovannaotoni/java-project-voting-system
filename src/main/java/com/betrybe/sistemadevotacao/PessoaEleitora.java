package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Instantiates a new Pessoa eleitora.
   *
   * @param nome   o nome
   * @param cpf o CPF da pessoa eleitora
   */
  public PessoaEleitora(String nome, String cpf) {
    setNome(nome);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
