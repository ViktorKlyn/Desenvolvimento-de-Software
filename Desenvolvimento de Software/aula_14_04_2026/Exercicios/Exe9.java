/*Exercício 9 (Difícil — Construção)
Enunciado
Crie um sistema com:
Classe Produto
• nome
• preco
Classe Carrinho
• lista de produtos
O que você deve fazer:
• Usar encapsulamento
• Criar método:
o adicionarProduto()
o calcularTotal()
Regras:
• não permitir produto com preço 0 */

import java.util.ArrayList;
class Produto{
    String nome;
    double preco;
}

class Carrinho{
    ArrayList<Object> Lista;

    void adicionarProduto(){
        ArrayList lista;
    }

    void calcularTotal(){
        int preco;
    }
}

public class Exe9{
    public static void main(String[] args) {
        if(preco < 0){
            System.out.println("Valor não permitido!");
        }
    }
}