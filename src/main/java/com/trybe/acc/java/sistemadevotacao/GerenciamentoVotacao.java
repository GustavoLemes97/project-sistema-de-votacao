package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que gerencia a votação.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método para cadastrar candidato.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean numeroEstaDisponivel = true;

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        numeroEstaDisponivel = false;
      }
    }

    if (numeroEstaDisponivel) {
      PessoaCandidata newPessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(newPessoaCandidata);
    }
  }

  /**
   * Método para cadastrar eleitor.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean cpfEstaDisponivel = true;

    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        cpfEstaDisponivel = false;
      }
    }

    if (cpfEstaDisponivel) {
      PessoaEleitora newPessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(newPessoaEleitora);
    }
  }

  /**
   * Método para cadastrar voto.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean pessoaJaVotou = false;

    for (String cpf : cpfComputado) {
      if (cpfPessoaEleitora.equals(cpf)) {
        System.out.println("Pessoa eleitora já votou!");
        pessoaJaVotou = true;
      }
    }

    if (!pessoaJaVotou) {
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          totalVotos += 1;
          pessoaCandidata.receberVoto();
          cpfComputado.add(cpfPessoaEleitora);
        }
      }
    }
  }

  private double calcularPorcentagemVotos(int indice) {
    PessoaCandidata pessoaCandidata = pessoasCandidatas.get(indice);
    double valor = ((double) pessoaCandidata.getVotos() / totalVotos) * 100;

    return Math.round(valor);
  }

  /**
   * Método para mostrar o resultado da eleição.
   */
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (int indice = 0; indice < pessoasCandidatas.size(); indice += 1) {
        double percentual = calcularPorcentagemVotos(indice);
        System.out.println("Nome: "
                + pessoasCandidatas.get(indice).getNome()
                + " - "
                + pessoasCandidatas.get(indice).getVotos()
                + " votos "
                + "( " + percentual + "% )");
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }
}
