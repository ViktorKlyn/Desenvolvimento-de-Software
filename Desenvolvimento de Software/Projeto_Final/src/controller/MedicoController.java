package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Medico;
import persistence.ArquivoManager;

/**
 * Controlador responsável por criar, consultar, alterar, excluir e persistir médicos.
 */
public class MedicoController {
    private final List<Medico> medicos;
    private final ArquivoManager arquivoManager;

    public MedicoController() {
        this.medicos = new ArrayList<>();
        this.arquivoManager = new ArquivoManager("medicos.txt");
    }

    public void carregarMedicos() {
        medicos.clear();
        try {
            List<String> linhas = arquivoManager.carregarDados();
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length >= 8) {
                    try {
                        double salario = Double.parseDouble(partes[5]);
                        Medico medico = new Medico(partes[0], partes[1], partes[2], partes[3], partes[4], salario, partes[6], partes[7]);
                        medicos.add(medico);
                    } catch (NumberFormatException e) {
                        System.err.println("Linha de médico inválida, ignorando: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar médicos: " + e.getMessage());
        }
    }

    public void salvarMedicos() {
        try {
            List<String> linhas = new ArrayList<>();
            for (Medico medico : medicos) {
                linhas.add(formatarMedico(medico));
            }
            arquivoManager.atualizarDados(linhas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar médicos: " + e.getMessage());
        }
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
        salvarMedicos();
    }

    public Optional<Medico> buscarMedicoPorId(String id) {
        return medicos.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public Optional<Medico> buscarMedicoPorCpf(String cpf) {
        return medicos.stream().filter(m -> m.getCpf().equals(cpf)).findFirst();
    }

    public boolean atualizarMedico(Medico medicoAtualizado) {
        Optional<Medico> existente = buscarMedicoPorId(medicoAtualizado.getId());
        if (existente.isPresent()) {
            Medico medico = existente.get();
            medico.setNome(medicoAtualizado.getNome());
            medico.setCpf(medicoAtualizado.getCpf());
            medico.setTelefone(medicoAtualizado.getTelefone());
            medico.setMatricula(medicoAtualizado.getMatricula());
            medico.setSalario(medicoAtualizado.getSalario());
            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
            medico.setCrm(medicoAtualizado.getCrm());
            salvarMedicos();
            return true;
        }
        return false;
    }

    public boolean excluirMedico(String id) {
        Optional<Medico> existente = buscarMedicoPorId(id);
        if (existente.isPresent()) {
            medicos.remove(existente.get());
            salvarMedicos();
            return true;
        }
        return false;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    private String formatarMedico(Medico medico) {
        return medico.getId() + ";" + medico.getNome() + ";" + medico.getCpf() + ";" + medico.getTelefone() + ";" + medico.getMatricula() + ";" + medico.getSalario() + ";" + medico.getEspecialidade() + ";" + medico.getCrm();
    }
}
