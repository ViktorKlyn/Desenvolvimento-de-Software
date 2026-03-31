class Pessoa{
    String nome = "João";
    int idade = 19;

}

class Funcionario extends Pessoa{
    double salario = 1900.0;
}

public class Herança{
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.nome = "Henrique";
        funcionario1.idade = 32;
        funcionario1.salario = 10.000;

        System.out.println("Nome: " + funcionario1.nome);
        System.out.println("Idade: " + funcionario1.idade);
        System.out.println("Salario: " + funcionario1.salario);
    }
}
