package application;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import entities.Pessoa;
import entities.Documento;

public class main {
    public static void main(String[] args) {
        String jsonFilePath = "src/data/dados.json";

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            List<Pessoa> pessoas = new Gson().fromJson(jsonContent, new TypeToken<List<Pessoa>>(){}.getType());

            System.out.println("\nLocaliza pessoa pelo ID:");
            listarPessoaPorId(pessoas, 2); //id indicado no exemplo

            System.out.println("\nListagem de pessoas em ordem crescente de idade:");
            listarPessoasPorIdadeCrescente(pessoas);

            System.out.println("\nPessoas com idade superior a 50 anos:");
            listarPessoasComMaisDe50Anos(pessoas);

            System.out.println("\nPessoas que não possuem CPF:");
            listarPessoasSemCPF(pessoas);

            System.out.println("\nListagem de tipos de documentos:");
            listarTiposDeDocumentos(pessoas);

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void listarPessoaPorId(List<Pessoa> pessoas, int id) {
        pessoas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .forEach(pessoa -> System.out.println(pessoa.getNome() + " (ID: " + pessoa.getId() + ")"));
    }

    public static void listarPessoasPorIdadeCrescente(List<Pessoa> pessoas) {
        pessoas.stream()
                .sorted(Comparator.comparingInt(Pessoa::getIdade))
                .forEach(pessoa -> System.out.printf("%s - %d anos\n", pessoa.getNome(), pessoa.getIdade()));
    }

    public static void listarPessoasComMaisDe50Anos(List<Pessoa> pessoas) {
        pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() > 50)
                .forEach(pessoa -> System.out.printf("%s - %d anos\n", pessoa.getNome(), pessoa.getIdade()));
    }

    public static void listarPessoasSemCPF(List<Pessoa> pessoas) {
        pessoas.stream()
                .filter(pessoa -> pessoa.getDocumentos().stream().noneMatch(doc -> doc.getTipo().equalsIgnoreCase("CPF")))
                .forEach(pessoa -> System.out.printf("%s (ID: %d)\n", pessoa.getNome(), pessoa.getId()));
    }

    public static void listarTiposDeDocumentos(List<Pessoa> pessoas) {
        pessoas.stream()
                .flatMap(pessoa -> pessoa.getDocumentos().stream())
                .map(Documento::getTipo)
                .distinct()
                .forEach(System.out::println);
    }
}
