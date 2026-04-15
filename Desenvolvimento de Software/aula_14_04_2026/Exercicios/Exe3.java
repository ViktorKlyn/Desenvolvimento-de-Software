/*Exercício 3 (Fácil — Construção)
Enunciado
Crie uma classe Aluno com:
• nome
• nota
O que você deve fazer:
• Usar construtor
• Validar nota entre 0 e 10
• Criar getters */

class Aluno{

    String nome;
    double nota;

    Aluno(String nome, int nota){
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome(){
        return nome;
    }

    public double getNota(){
        return nota;
    }

}

public class Exe3{
    public static void main(String[] args) {

        if(nota < 0 || nota > 10){
            System.out.println("Valor inválido!");
        }
    }
}