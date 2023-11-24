package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    cadastrarPessoaCandidata(scanner, gerenciamentoVotacao);
    cadastrarPessoaEleitora(scanner, gerenciamentoVotacao);
    votacao(scanner, gerenciamentoVotacao);
  }

  private static void cadastrarPessoaCandidata(Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao) {
    boolean continuar = true;
    while (continuar) {
      System.out.println("Cadastrar pessoa candidata?\n"
          + "1 - Sim\n"
          + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:"
      );

      String option = scanner.nextLine();
      short menuOption = Short.parseShort(option);

      switch (menuOption) {
        case 1: {
          System.out.println("Entre com o nome da pessoa candidata:");
          String nome = scanner.nextLine();
          System.out.println("Entre com o número da pessoa candidata:");
          String numStr = scanner.nextLine();
          int numero = Integer.parseInt(numStr);
          gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
          break;
        }
        case 2:
          continuar = false;
          break;
        default:
          System.out.println("Opção Inválida.");
      }
    }
  }

  private static void cadastrarPessoaEleitora(Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao) {
    boolean continuar = true;
    while (continuar) {
      System.out.println("Cadastrar pessoa eleitora?\n"
          + "1 - Sim\n"
          + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:"
      );

      String option = scanner.nextLine();
      short menuOption = Short.parseShort(option);

      switch (menuOption) {
        case 1: {
          System.out.println("Entre com o nome da pessoa eleitora:");
          String nome = scanner.nextLine();
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpf = scanner.nextLine();
          gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
          break;
        }
        case 2:
          continuar = false;
          break;
        default:
          System.out.println("Opção Inválida.");
      }
    }
  }

  private static void votacao(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    boolean continuar = true;
    while (continuar) {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Votar\n"
          + "2 - Resultado Parcial\n"
          + "3 - Finalizar Votação"
      );

      String option = scanner.nextLine();
      short menuOption = Short.parseShort(option);

      switch (menuOption) {
        case 1: {
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpf = scanner.nextLine();
          System.out.println("Entre com o número da pessoa candidata:");
          String numStr = scanner.nextLine();
          int numero = Integer.parseInt(numStr);
          gerenciamentoVotacao.votar(cpf, numero);
          break;
        }
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;
        case 3:
          gerenciamentoVotacao.mostrarResultado();
          continuar = false;
          break;
        default:
          System.out.println("Opção Inválida.");
      }
    }
  }
}
