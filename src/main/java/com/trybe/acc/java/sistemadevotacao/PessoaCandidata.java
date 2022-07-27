package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe para criar pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Método construtor da pessoa candidata.
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    votos = 0;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public void setNome(String nome) {
    this.nome = nome;
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

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    votos += 1;
  }
}
