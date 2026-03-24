class Car {
    String marca;
    String modelo;
    double velocidade;

    void acelerar() {
        System.out.println("O carro está acelerando");
    }
}

public class Carro {
    public static void main(String[] args) {
        Car carro1 = new Car();

        carro1.modelo = "208";
        carro1.marca = "Peugeot";
        carro1.velocidade = 180;

        carro1.acelerar();

        System.out.println("=== Dados do Carro ===");
        System.out.println("Marca: " + carro1.marca);
        System.out.println("Modelo: " + carro1.modelo);
        System.out.println("Velocidade: " + carro1.velocidade + " km/h");
    }
}