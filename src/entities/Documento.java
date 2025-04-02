package entities;

public class Documento {
  private String tipo;
  private String numero;
  private String descricao;

  public Documento(String tipo, String numero, String descricao) {
    this.tipo = tipo;
    this.numero = numero;
    this.descricao = descricao;
  }

  public String getTipo() {
    return tipo;
  }

  public String getNumero() {
    return numero;
  }

  public String getDescricao() {
    return descricao;
  }

  public String toString() {
    return String.format("Documento{tipo: '%s', numero: '%s', descricao: '%s'}", tipo, numero, descricao);
  }
}
