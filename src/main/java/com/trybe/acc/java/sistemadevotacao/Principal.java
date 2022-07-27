package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal com os menus do sistema.
 */
public class Principal {
  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    menuCandidatos(gerenciamentoVotacao, scanner);
    menuEleitores(gerenciamentoVotacao, scanner);
    menuVotacao(gerenciamentoVotacao, scanner);
  }

  /**
   * Método que cria o menu para cadastrar candidatos.
   */
  public static void menuCandidatos(GerenciamentoVotacao gerenciamentoVotacao, Scanner scanner) {
    short opcao;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcao = scanner.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    } while (opcao == 1);

  }

  /**
   * Método que cria o menu para cadastrar eleitores.
   */
  public static void menuEleitores(GerenciamentoVotacao gerenciamentoVotacao, Scanner scanner) {
    short opcao;
    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcao = scanner.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (opcao == 1);

  }

  /**
   * Método que cria o menu de votação.
   */
  public static void menuVotacao(GerenciamentoVotacao gerenciamentoVotacao, Scanner scanner) {
    short opcao;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Sim");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      opcao = scanner.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();

        gerenciamentoVotacao.votar(cpf, numero);
      } else if (opcao == 2 || opcao == 3) {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (opcao != 3);

  }
}
