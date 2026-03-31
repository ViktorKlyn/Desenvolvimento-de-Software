class Veiculo {
    String marca;
    String modelo;
}

class Carro extends Veiculo {
    int portas;
}

class Moto extends Veiculo {
    int cilindradas;
}

public class Veiculos {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.marca = "Toyota";
        carro1.modelo = "Hilux"; // Corrigido o nome
        carro1.portas = 4;

        Moto moto1 = new Moto();
        moto1.marca = "Honda";
        moto1.modelo = "Bros"; // Corrigido o nome
        moto1.cilindradas = 700;

        System.out.println("Carro:");
        System.out.println("Marca: " + carro1.marca);
        System.out.println("Modelo: " + carro1.modelo);
        System.out.println("Portas: " + carro1.portas);

        System.out.println("\nMoto:");
        System.out.println("Marca: " + moto1.marca);
        System.out.println("Modelo: " + moto1.modelo);
        System.out.println("Cilindradas: " + moto1.cilindradas);
    }
}