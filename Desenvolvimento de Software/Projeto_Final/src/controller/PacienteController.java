package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Paciente;
import persistence.ArquivoManager;

/**
 * Controlador responsável por criar, consultar, alterar e excluir pacientes.
 */
public class PacienteController {
    private final List<Paciente> pacientes;
    private final ArquivoManager arquivoManager;

    public PacienteController() {
        this.pacientes = new ArrayList<>();
        this.arquivoManager = new ArquivoManager("pacientes.txt");
    }

    public void carregarPacientes() {
        pacientes.clear();
        try {
            List<String> linhas = arquivoManager.carregarDados();
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length >= 5) {
                    Paciente paciente = new Paciente(partes[0], partes[1], partes[2], partes[3], partes[4]);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar pacientes: " + e.getMessage());
        }
    }

    public void salvarPacientes() {
        try {
            List<String> linhas = new ArrayList<>();
            for (Paciente paciente : pacientes) {
                linhas.add(formatarPaciente(paciente));
            }
            arquivoManager.atualizarDados(linhas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        salvarPacientes();
    }

    public Optional<Paciente> buscarPacientePorId(String id) {
        return pacientes.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Optional<Paciente> buscarPacientePorCpf(String cpf) {
        return pacientes.stream().filter(p -> p.getCpf().equals(cpf)).findFirst();
    }

    public boolean atualizarPaciente(Paciente pacienteAtualizado) {
        Optional<Paciente> pacienteExistente = buscarPacientePorId(pacienteAtualizado.getId());
        if (pacienteExistente.isPresent()) {
            Paciente paciente = pacienteExistente.get();
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setCpf(pacienteAtualizado.getCpf());
            paciente.setTelefone(pacienteAtualizado.getTelefone());
            paciente.setConvenio(pacienteAtualizado.getConvenio());
            salvarPacientes();
            return true;
        }
        return false;
    }

    public boolean excluirPaciente(String id) {
        Optional<Paciente> pacienteExistente = buscarPacientePorId(id);
        if (pacienteExistente.isPresent()) {
            pacientes.remove(pacienteExistente.get());
            salvarPacientes();
            return true;
        }
        return false;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    private String formatarPaciente(Paciente paciente) {
        return paciente.getId() + ";" + paciente.getNome() + ";" + paciente.getCpf() + ";" + paciente.getTelefone() + ";" + paciente.getConvenio();
    }
}
