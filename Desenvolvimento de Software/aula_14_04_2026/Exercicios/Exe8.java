/*Exercício 8 (Difícil — Correção)
Código com erro:
import java.util.ArrayList;
class Pedido {
private ArrayList<String> produtos;
public void adicionarProduto(String p) {
produtos.add(p);
}
}
O que você deve fazer:
• Identificar o erro
• Corrigir a inicialização da lista
• Explicar por que ocorre erro */

import java.util.ArrayList;

class Pedido {
    private ArrayList<String> produtos;

    public void adicionarProduto(String p) {
        produtos.add(p);
    }
}