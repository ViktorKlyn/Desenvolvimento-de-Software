package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia operações de persistência em arquivos TXT.
 */
public class ArquivoManager {
    private final String caminhoArquivo;

    public ArquivoManager(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    private File arquivo() {
        return new File(System.getProperty("user.dir"), caminhoArquivo);
    }

    public void salvarDados(List<String> linhas) throws IOException {
        File arquivo = arquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        }
    }

    public List<String> carregarDados() throws IOException {
        List<String> linhas = new ArrayList<>();
        File arquivo = arquivo();
        if (!arquivo.exists()) {
            arquivo.createNewFile();
            return linhas;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }
        return linhas;
    }

    public void atualizarDados(List<String> linhas) throws IOException {
        File arquivo = arquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, false))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        }
    }

    public void excluirDados() throws IOException {
        File arquivo = arquivo();
        if (arquivo.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, false))) {
                writer.write("");
            }
        }
    }
}
