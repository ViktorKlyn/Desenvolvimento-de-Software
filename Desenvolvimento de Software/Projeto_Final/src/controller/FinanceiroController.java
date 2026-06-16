package controller;

import interfaces.Relatorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Consulta;
import model.Fatura;
import model.Pagamento;
import persistence.ArquivoManager;

/**
 * Controlador financeiro que gerencia faturas, pagamentos e relatórios.
 */
public class FinanceiroController implements Relatorio {
    private final List<Fatura> faturas;
    private final List<Pagamento> pagamentos;
    private final ArquivoManager arquivoFaturas;
    private final ArquivoManager arquivoPagamentos;

    public FinanceiroController() {
        this.faturas = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
        this.arquivoFaturas = new ArquivoManager("faturas.txt");
        this.arquivoPagamentos = new ArquivoManager("pagamentos.txt");
    }

    public void carregarFaturas(List<Consulta> consultas) {
        faturas.clear();
        try {
            List<String> linhas = arquivoFaturas.carregarDados();
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length >= 4) {
                    String id = partes[0];
                    String consultaId = partes[1];
                    double valorTotal = Double.parseDouble(partes[2]);
                    String statusPagamento = partes[3];

                    Optional<Consulta> consulta = consultas.stream().filter(c -> c.getId().equals(consultaId)).findFirst();
                    consulta.ifPresent(value -> faturas.add(new Fatura(id, value, valorTotal, statusPagamento)));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar faturas: " + e.getMessage());
        }
    }

    public void carregarPagamentos() {
        pagamentos.clear();
        try {
            List<String> linhas = arquivoPagamentos.carregarDados();
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length >= 4) {
                    try {
                        String id = partes[0];
                        String faturaId = partes[1];
                        double valorPago = Double.parseDouble(partes[2]);
                        String dataPagamento = partes[3];

                        Optional<Fatura> fatura = faturas.stream().filter(f -> f.getId().equals(faturaId)).findFirst();
                        fatura.ifPresent(value -> pagamentos.add(new Pagamento(id, value, valorPago, dataPagamento)));
                    } catch (NumberFormatException e) {
                        System.err.println("Linha de pagamento inválida, ignorando: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar pagamentos: " + e.getMessage());
        }
    }

    public void salvarFaturas() {
        try {
            List<String> linhas = new ArrayList<>();
            for (Fatura fatura : faturas) {
                linhas.add(formatarFatura(fatura));
            }
            arquivoFaturas.atualizarDados(linhas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar faturas: " + e.getMessage());
        }
    }

    public void salvarPagamentos() {
        try {
            List<String> linhas = new ArrayList<>();
            for (Pagamento pagamento : pagamentos) {
                linhas.add(formatarPagamento(pagamento));
            }
            arquivoPagamentos.atualizarDados(linhas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pagamentos: " + e.getMessage());
        }
    }

    public void adicionarFatura(Fatura fatura) {
        faturas.add(fatura);
        salvarFaturas();
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        atualizarStatusFatura(pagamento.getFatura());
        salvarPagamentos();
        salvarFaturas();
    }

    private void atualizarStatusFatura(Fatura fatura) {
        double totalPago = pagamentos.stream()
                .filter(p -> p.getFatura().getId().equals(fatura.getId()))
                .mapToDouble(Pagamento::getValorPago)
                .sum();
        if (totalPago >= fatura.getValorTotal()) {
            fatura.setStatusPagamento("PAGO");
        } else {
            fatura.setStatusPagamento("PENDENTE");
        }
    }

    public Optional<Fatura> buscarFaturaPorId(String id) {
        return faturas.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Optional<Pagamento> buscarPagamentoPorId(String id) {
        return pagamentos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    private String formatarFatura(Fatura fatura) {
        return fatura.getId() + ";" + fatura.getConsulta().getId() + ";" + fatura.getValorTotal() + ";" + fatura.getStatusPagamento();
    }

    private String formatarPagamento(Pagamento pagamento) {
        return pagamento.getId() + ";" + pagamento.getFatura().getId() + ";" + pagamento.getValorPago() + ";" + pagamento.getDataPagamento();
    }

    @Override
    public void gerarRelatorio() {
        double totalFaturado = faturas.stream().mapToDouble(Fatura::calcularValor).sum();
        double totalRecebido = pagamentos.stream().mapToDouble(Pagamento::calcularValor).sum();
        double totalPendente = faturas.stream()
                .filter(f -> "PENDENTE".equalsIgnoreCase(f.getStatusPagamento()))
                .mapToDouble(Fatura::getValorTotal)
                .sum();

        System.out.println("=== Relatório Financeiro ===");
        for (Fatura fatura : faturas) {
            String paciente = fatura.getConsulta().getPaciente().getNome();
            String medico = fatura.getConsulta().getMedico().getNome();
            String situacao = fatura.getStatusPagamento();
            System.out.println("Paciente: " + paciente);
            System.out.println("Médico responsável: " + medico);
            System.out.println("Valor da consulta: " + fatura.getConsulta().getValor());
            System.out.println("Valor da fatura: " + fatura.getValorTotal());
            System.out.println("Situação do pagamento: " + situacao);
            System.out.println("-----------------------------");
        }
        System.out.println("Total faturado: " + totalFaturado);
        System.out.println("Total recebido: " + totalRecebido);
        System.out.println("Total pendente: " + totalPendente);
    }
}
