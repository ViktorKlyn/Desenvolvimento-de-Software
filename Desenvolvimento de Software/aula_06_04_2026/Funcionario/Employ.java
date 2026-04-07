class Funcionario{
    String nome;
    double salario;

    Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }
}

public class Employ{
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("João", 10000.0 + 10000.0 * 0.1);

        System.out.println("Nome: " + f1.nome);
        System.out.println("Salario: " + f1.salario);
    }
}