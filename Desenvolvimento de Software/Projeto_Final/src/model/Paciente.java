package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um paciente e estende a classe Pessoa.
 * Contém informações de convênio e histórico financeiro.
 */
public class Paciente extends Pessoa {
    private String convenio;
    private List<String> historicoFinanceiro;

    public Paciente() {
        this.historicoFinanceiro = new ArrayList<>();
    }

    public Paciente(String id, String nome, String cpf, String telefone, String convenio) {
        super(id, nome, cpf, telefone);
        this.convenio = convenio;
        this.historicoFinanceiro = new ArrayList<>();
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public List<String> getHistoricoFinanceiro() {
        return historicoFinanceiro;
    }

    public void setHistoricoFinanceiro(List<String> historicoFinanceiro) {
        this.historicoFinanceiro = historicoFinanceiro;
    }

    public void adicionarHistorico(String registro) {
        this.historicoFinanceiro.add(registro);
    }

    @Override
    public String toString() {
        return "Paciente{" + super.toString() + ", Convenio='" + convenio + '\'' + ", HistoricoFinanceiro=" + historicoFinanceiro + '}';
    }
}
