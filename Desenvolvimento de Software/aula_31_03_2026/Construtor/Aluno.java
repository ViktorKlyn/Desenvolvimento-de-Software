class Student {
    String nome;
    int idade;

    public Student(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class Aluno {
    public static void main(String[] args) {
        Student p = new Student("João", 19);

        System.out.println("Nome: " + p.nome);
        System.out.println("Idade: " + p.idade);
    }
}
