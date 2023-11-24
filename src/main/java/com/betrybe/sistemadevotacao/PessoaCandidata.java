package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {
  protected int numero;
  protected int votos;

  /**
   * Instantiates a new Pessoa candidata.
   *
   * @param nome   o nome
   * @param numero o número identificador para voto
   */
  public PessoaCandidata(String nome, int numero) {
    setNome(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
