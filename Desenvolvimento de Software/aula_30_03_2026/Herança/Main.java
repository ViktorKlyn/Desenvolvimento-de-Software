class Animal{
    String nome;
}

class Cachorro extends Animal{
    String raca;
}

public class Main{
    public static void main(String[] args) {
        Cachorro cachorro1 = new Cachorro();

        cachorro1.nome = "Freeza Maria";
        cachorro1.raca = "Pitbul";

        System.out.println("Nome: " + cachorro1.nome);
        System.out.println("Raça: " + cachorro1.raca);
    }
}