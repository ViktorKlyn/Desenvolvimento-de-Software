/*Exercício 4 (Médio — Correção)
Código com erro:
class ContaBancaria {
private double saldo;
public void setSaldo(double saldo) {
this.saldo = saldo;
}
}
O que você deve fazer:
• Identificar o erro lógico
• Corrigir o setter
• Impedir saldo negativo */

class contaBancaria {
    private double saldo;

    void setSaldo(double  saldo){
        this.saldo = saldo;
    }
}

public class Exe4{
    public static void main(String[] args) {

        if(saldo < 0){
            System.out.println("Valor inválido!");
        }
    }
}