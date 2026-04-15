/*Exercício 10 (Difícil — Correção)
Código com erro:
class Pedido {
private double total;
public void aplicarDesconto(double valor) {
total = total - valor;
}
}
O que você deve fazer:
• Identificar o problema lógico
• Corrigir o método
• Garantir que o total não fique negativo */

class Pedido {
    private double total;

    void aplicarDesconto(double valor){
        total -= valor;
    }

    if(total<0)

    {
        System.out.println("Deu erro!");
    }
}