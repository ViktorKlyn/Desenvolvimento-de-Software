/*Exercício 1 (Fácil — Construção)
Enunciado
Crie uma classe Pessoa com:
• nome
• idade
O que você deve fazer:
• Tornar os atributos private
• Criar um construtor
• Criar getters
• Validar que idade não pode ser negativa */

import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class Exe1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = entrada.nextInt();

        if (idade < 0) {
            System.err.println("Idade Inválida!");
        }
    }
}
