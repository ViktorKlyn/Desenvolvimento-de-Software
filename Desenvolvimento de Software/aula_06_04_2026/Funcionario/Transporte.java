class Carro {
    String marca;
    String modelo;
    int ano;

    Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
}

public class Transporte {
    public static void main(String[] args) {
        Carro c1 = new Carro("Toyota", "Hylux", 2025);
        Carro c2 = new Carro("GM", "Dodge Ram", 2025);

        System.out.println("Carro 1: " + c1.marca + " " + c1.modelo + " - Ano: " + c1.ano);
        System.out.println("Carro 2: " + c2.marca + " " + c2.modelo + " - Ano: " + c2.ano);
    }
}