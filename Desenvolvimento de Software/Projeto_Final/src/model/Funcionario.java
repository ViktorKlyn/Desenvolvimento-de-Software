package model;

/**
 * Representa um funcionário do hospital, que é uma pessoa com matrícula e salário.
 */
public class Funcionario extends Pessoa {
    private String matricula;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String id, String nome, String cpf, String telefone, String matricula, double salario) {
        super(id, nome, cpf, telefone);
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + super.toString() + ", Matricula='" + matricula + '\'' + ", Salario=" + salario + '}';
    }
}
