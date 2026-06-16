package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Consulta;
import model.Medico;
import model.Paciente;
import persistence.ArquivoManager;

/**
 * Controlador responsável pelo cadastro e consulta de consultas.
 */
public class ConsultaController {
    private final List<Consulta> consultas;
    private final ArquivoManager arquivoManager;

    public ConsultaController() {
        this.consultas = new ArrayList<>();
        this.arquivoManager = new ArquivoManager("consultas.txt");
    }

    public void carregarConsultas(List<Paciente> pacientes, List<Medico> medicos) {
        consultas.clear();
        try {
            List<String> linhas = arquivoManager.carregarDados();
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length >= 5) {
                    try {
                        String id = partes[0];
                        String data = partes[1];
                        double valor = Double.parseDouble(partes[2]);
                        String pacienteId = partes[3];
                        String medicoId = partes[4];

                        Optional<Paciente> paciente = pacientes.stream().filter(p -> p.getId().equals(pacienteId)).findFirst();
                        Optional<Medico> medico = medicos.stream().filter(m -> m.getId().equals(medicoId)).findFirst();
                        if (paciente.isPresent() && medico.isPresent()) {
                            consultas.add(new Consulta(id, data, valor, paciente.get(), medico.get()));
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Linha de consulta inválida, ignorando: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar consultas: " + e.getMessage());
        }
    }

    public void salvarConsultas() {
        try {
            List<String> linhas = new ArrayList<>();
            for (Consulta consulta : consultas) {
                linhas.add(formatarConsulta(consulta));
            }
            arquivoManager.atualizarDados(linhas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar consultas: " + e.getMessage());
        }
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        salvarConsultas();
    }

    public Optional<Consulta> buscarConsultaPorId(String id) {
        return consultas.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    private String formatarConsulta(Consulta consulta) {
        return consulta.getId() + ";" + consulta.getData() + ";" + consulta.getValor() + ";" + consulta.getPaciente().getId() + ";" + consulta.getMedico().getId();
    }
}
