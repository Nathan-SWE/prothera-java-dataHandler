package application;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import entities.Pessoa;

public class main {
    public static void main(String[] args) {
        String jsonFilePath = "src/data/dados.json";

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            List<Pessoa> pessoas = new Gson().fromJson(jsonContent, new TypeToken<List<Pessoa>>(){}.getType());

            System.out.println("\nLocaliza pessoa pelo ID:");
            listarPessoaPorId(pessoas, 2); //id indicado no exemplo

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void listarPessoaPorId(List<Pessoa> pessoas, int id) {
        pessoas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .forEach(pessoa -> System.out.println(pessoa.getNome() + " (ID: " + pessoa.getId() + ")"));
    }
}
