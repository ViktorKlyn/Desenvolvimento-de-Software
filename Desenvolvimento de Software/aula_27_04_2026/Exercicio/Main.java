import java.util.ArrayList;

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio!");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

class Carro {
    private String marca;
    private String modelo;
    private double preco;

    public Carro(String marca, String modelo, double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que 0!");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " - R$ " + preco;
    }
}

class Estoque {
    private ArrayList<Carro> carros;

    public Estoque() {
        carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public void listarCarros() {
        System.out.println("===== ESTOQUE =====");
        for (Carro c : carros) {
            System.out.println(c);
        }
    }

    public double calcularValorTotalEstoque() {
        double total = 0;
        for (Carro c : carros) {
            total += c.getPreco();
        }
        return total;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }
}

class Venda {
    private Cliente cliente;
    private Carro carro;

    public Venda(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
    }

    public void mostrarResumoVenda() {
        System.out.println("===== VENDA =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo());
        System.out.println("Preço: R$ " + carro.getPreco());
    }
}

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Maria", "12345678900");

        Carro carro1 = new Carro("Toyota", "Corolla", 120000);
        Carro carro2 = new Carro("Honda", "Civic", 130000);
        Carro carro3 = new Carro("Fiat", "Argo", 80000);

        Estoque estoque = new Estoque();
        estoque.adicionarCarro(carro1);
        estoque.adicionarCarro(carro2);
        estoque.adicionarCarro(carro3);

        estoque.listarCarros();

        System.out.println("Valor total do estoque: R$ " + estoque.calcularValorTotalEstoque());

        Venda venda = new Venda(cliente, carro2);
        venda.mostrarResumoVenda();
    }
}
