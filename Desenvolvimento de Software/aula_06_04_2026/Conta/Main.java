class ContaBancaria {
    String titular;
    double saldo;

    ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
}

public class Main {
    public static void main(String[] args) {
        ContaBancaria p1 = new ContaBancaria("Viktor", 1000.0);

        System.out.println("Titular: " + p1.titular);
        System.out.println("Saldo: " + p1.saldo);
    }
}