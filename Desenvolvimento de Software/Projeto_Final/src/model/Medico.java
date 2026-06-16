package model;

/**
 * Representa um médico, que é um funcionário com especialidade e CRM.
 */
public class Medico extends Funcionario {
    private String especialidade;
    private String crm;

    public Medico() {
    }

    public Medico(String id, String nome, String cpf, String telefone, String matricula, double salario, String especialidade, String crm) {
        super(id, nome, cpf, telefone, matricula, salario);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico{" + super.toString() + ", Especialidade='" + especialidade + '\'' + ", CRM='" + crm + '\'' + '}';
    }
}
