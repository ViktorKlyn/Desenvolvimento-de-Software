class Car {
    String marca;
    String modelo;

    public Car() {
    }

    public Car(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}

public class Carro {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Hilux");

        System.out.println("Marca: " + car.marca);
        System.out.println("Modelo: " + car.modelo);
    }
}
