package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      // utiliza-se o == para comparar igualdade entre tipos primitivos
      // compara-se com base no endereço de memória
      if (pessoa.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      // utiliza-se o equals porque String é um tipo não primitivo
      // compara-se o conteúdo do objeto
      if (pessoa.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }

    System.out.println("Pessoa candidata não cadastrada!");
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
      return;
    }

    int totalVotos = cpfsComputados.size();
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      // utiliza-se o casting para converter o resultado para float e em seguida a arredondá-lo
      int percentualVotos = Math.round((float) (pessoaCandidata.getVotos() * 100 / totalVotos));
      System.out.printf("Nome: %s - %d votos ( %d )\n",
          pessoaCandidata.getNome(), pessoaCandidata.getVotos(), percentualVotos);
    }
    System.out.println("Total de votos: " + totalVotos);
  }
}
