/*Exercício 7 (Médio — Construção)
Enunciado
Crie uma classe Carro com:
• marca
• velocidade
O que você deve fazer:
• Usar encapsulamento
• Criar construtor
• Criar métodos:
o acelerar(int valor)
o frear(int valor)
Regras:
• velocidade não pode ser negativa */

class Carro{
    String marca;
    double velocidade;

    Carro(String marca, int velocidade){
        this.marca = marca;
        this.velocidade = velocidade;
    }

    void acelerar(int valor){
        System.out.println("Vrummm...");
    }

    void frear(int valor){
        System.out.println("Schiiiii");
    }
}

public class Exe7{
    public static void main(String[] args) {
        if(Velocidade < 0){
            System.err.println("Não existe velocidade negativa!");
        }
    }
}