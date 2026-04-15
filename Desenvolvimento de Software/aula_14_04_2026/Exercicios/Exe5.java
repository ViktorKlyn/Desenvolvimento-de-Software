/*Exercício 5 (Médio — Construção)
Enunciado
Crie uma classe Produto com:
• nome
• preco
O que você deve fazer:
• Criar construtor
• Usar encapsulamento
• Criar método:
aplicarDesconto(double percentual)
Regras:
• percentual entre 0 e 100
• não permitir preço negativo */

class Produto{
    String nome;
    double preco;

    Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    void aplicarDesconto(double percentual){
        System.err.println("Entre 0 e 100: ");
    }
}

public class Exe5{
    public static void main(String[] args) {
        if(preco < 0){
            System.err.println("Valor inválido!");
        }
    }
}