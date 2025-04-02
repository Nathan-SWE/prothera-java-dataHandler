package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
  public static void main(String[] args) {
    String jsonFilePath = "src/data/dados.json";
    String jsonContent = lerArquivoJson(jsonFilePath);

    if (jsonContent != null) {
      System.out.println("JSON carregado com sucesso!");
      System.out.println(jsonContent);
    } else {
      System.out.println("Erro ao carregar o JSON");
    }
  }

  public static String lerArquivoJson(String caminho) {
    StringBuilder conteudo = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
      String linha;

      while ((linha = br.readLine()) != null) {
        conteudo.append(linha);        
      }
      return conteudo.toString();
    } catch (IOException error) {
      error.printStackTrace();
      return null;
    }
  }
}
