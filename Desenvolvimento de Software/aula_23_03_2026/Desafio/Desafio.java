class Universidade {
    String nome;
    String cidade;
}

class Professor {
    String nome;
    String disciplina;
}

public class Desafio{
    public static void main(String[] args) {
         Universidade universidade1 = new Universidade();
        universidade1.nome = "Universidade Cruzeiro do Sul";
        universidade1.cidade = "São Paulo";

        Professor professor1 = new Professor();
        professor1.nome = "Carlos Silva";
        professor1.disciplina = "Programação Orientada a Objetos";

        System.out.println("=== Dados da Universidade ===");
        System.out.println("Nome: " + universidade1.nome);
        System.out.println("Cidade: " + universidade1.cidade);

        System.out.println("\n=== Dados do Professor ===");
        System.out.println("Nome: " + professor1.nome);
        System.out.println("Disciplina: " + professor1.disciplina);
    }
}