/*Exercício 2 (Fácil — Correção)
Código com erro:
class Produto {
public String nome;
public double preco;
}
Produto p = new Produto();
p.preco = -100;
O que você deve fazer:
• Identificar o problema
• Corrigir usando encapsulamento
• Impedir preço negativo */

import java.util.Scanner;

class Produto {
    public String nome;
    public double preco;

    Produto(String nome, double preco) {
        Produto p = new Produto();
        p.preco = -100;
    }

}

public class Exe2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String nome = entrada.nextLine();

        System.out.println("Digite o preço do produto: ");
        int preco = entrada.nextDouble();

        if (preco < 0) {
            System.out.println("Valor inválido!");
        }
    }
}