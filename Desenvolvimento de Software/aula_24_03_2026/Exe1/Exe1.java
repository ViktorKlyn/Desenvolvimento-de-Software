import java.util.ArrayList;

class Aluno {
    String nome;
    int idade;
}

public class Exe1 {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();

        Aluno aluno1 = new Aluno();
        aluno1.nome = "Maria";
        aluno1.idade = 34;

        Aluno aluno2 = new Aluno();
        aluno2.nome = "Henrique";
        aluno2.idade = 32;

        Aluno aluno3 = new Aluno();
        aluno3.nome = "Joao";
        aluno3.idade = 12;

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);

        for(Aluno a : alunos) {
            System.out.println(a.nome);
            System.out.println(a.idade);
        }
    }
}