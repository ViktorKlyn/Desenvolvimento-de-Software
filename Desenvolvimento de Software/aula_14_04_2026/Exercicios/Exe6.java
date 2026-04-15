/*Exercício 6 (Médio — Correção)
Código com erro:
class Aluno {
String nome;
public Aluno(String nome) {
nome = nome;
}
}
O que você deve fazer:
• Identificar o erro
• Corrigir usando this
• Aplicar encapsulamento */

class Aluno{
    String nome;

    Aluno(String nome){
        this.nome = nome;
    }
}

public class Exe6{
    public static void main(String[] args) {
        
    }
}