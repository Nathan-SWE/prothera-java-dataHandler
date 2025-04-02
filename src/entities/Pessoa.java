package entities;

import java.util.List;

public class Pessoa {
  private int id;
  private String nome;
  private int idade;
  private List<Documento> documentos;

  public Pessoa(int id, String nome, int idade, List<Documento> documentos){
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.documentos = documentos;
  }

  public int getId() {
    return id;  
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public List<Documento> getDocumentos() {
    return documentos;
  }

  public String toString() {
    return String.format("Pessoa{id: %d, nome: '%s', idade: %d, documentos: %s}", id, nome, idade, documentos);
  }
}
