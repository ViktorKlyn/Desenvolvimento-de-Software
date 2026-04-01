class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Maria", 25);
        
        System.out.println("Nome: " + p.nome);
        System.out.println("Idade: " + p.idade);
    }
}