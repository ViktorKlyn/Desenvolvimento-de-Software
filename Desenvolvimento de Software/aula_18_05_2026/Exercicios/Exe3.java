import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Entregador {
    private String nome;
    private double distanciaEntrega;

    public Entregador(String nome, double distanciaEntrega) {
        this.nome = nome;
        this.distanciaEntrega = distanciaEntrega;
    }

    public String getNome() {
        return nome;
    }

    public double getDistanciaEntrega() {
        return distanciaEntrega;
    }

    public abstract double calcularEntrega();

    public void mostrarResumoEntrega() {
        System.out.println("Nome: " + nome + " | Distância: " + String.format("%.2f", distanciaEntrega) 
                         + " km | Valor: R$ " + String.format("%.2f", calcularEntrega()));
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Distância: " + String.format("%.2f", distanciaEntrega) 
               + " km | Valor: R$ " + String.format("%.2f", calcularEntrega());
    }
}

class Moto extends Entregador {
    private static final double TAXA_FIXA = 10.0;
    private static final double VALOR_KM = 2.0;

    public Moto(String nome, double distanciaEntrega) {
        super(nome, distanciaEntrega);
    }

    @Override
    public double calcularEntrega() {
        return TAXA_FIXA + (getDistanciaEntrega() * VALOR_KM);
    }
}

class Bicicleta extends Entregador {
    private static final double VALOR_KM = 1.5;

    public Bicicleta(String nome, double distanciaEntrega) {
        super(nome, distanciaEntrega);
    }

    @Override
    public double calcularEntrega() {
        return getDistanciaEntrega() * VALOR_KM;
    }
}

class Carro extends Entregador {
    private static final double TAXA_COMBUSTIVEL = 25.0;
    private static final double VALOR_KM = 2.5;

    public Carro(String nome, double distanciaEntrega) {
        super(nome, distanciaEntrega);
    }

    @Override
    public double calcularEntrega() {
        return TAXA_COMBUSTIVEL + (getDistanciaEntrega() * VALOR_KM);
    }
}

public class Exe3 {
    private static List<Entregador> entregadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarEntregador();
                    break;
                case 2:
                    listarEntregadores();
                    break;
                case 3:
                    mostrarValorTotal();
                    break;
                case 4:
                    mostrarResumo();
                    break;
                case 5:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE DELIVERY ===");
        System.out.println("1. Adicionar entregador");
        System.out.println("2. Listar entregadores");
        System.out.println("3. Mostrar valor total de entregas");
        System.out.println("4. Mostrar resumo das entregas");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarEntregador() {
        System.out.print("Digite o nome do entregador: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a distância da entrega (km): ");
        double distancia = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nEscolha o tipo de entregador:");
        System.out.println("1. Moto (taxa: R$ 10.00)");
        System.out.println("2. Bicicleta (sem taxa)");
        System.out.println("3. Carro (taxa: R$ 25.00)");
        System.out.print("Digite a opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1:
                entregadores.add(new Moto(nome, distancia));
                System.out.println("✓ Moto adicionada com sucesso!");
                break;
            case 2:
                entregadores.add(new Bicicleta(nome, distancia));
                System.out.println("✓ Bicicleta adicionada com sucesso!");
                break;
            case 3:
                entregadores.add(new Carro(nome, distancia));
                System.out.println("✓ Carro adicionado com sucesso!");
                break;
            default:
                System.out.println("Tipo inválido!");
        }
    }

    private static void listarEntregadores() {
        if (entregadores.isEmpty()) {
            System.out.println("\nNenhum entregador cadastrado.");
            return;
        }

        System.out.println("\n=== LISTA DE ENTREGADORES ===");
        for (int i = 0; i < entregadores.size(); i++) {
            System.out.println((i + 1) + ". " + entregadores.get(i));
        }
    }

    private static void mostrarValorTotal() {
        if (entregadores.isEmpty()) {
            System.out.println("\nNenhum entregador cadastrado.");
            return;
        }

        double valorTotal = 0;
        for (Entregador e : entregadores) {
            valorTotal += e.calcularEntrega();
        }

        System.out.println("\n=== VALOR TOTAL DE ENTREGAS ===");
        System.out.println("Total: R$ " + String.format("%.2f", valorTotal));
    }

    private static void mostrarResumo() {
        if (entregadores.isEmpty()) {
            System.out.println("\nNenhum entregador cadastrado.");
            return;
        }

        System.out.println("\n=== RESUMO DAS ENTREGAS ===");
        for (Entregador e : entregadores) {
            e.mostrarResumoEntrega();
        }

        double valorTotal = 0;
        for (Entregador e : entregadores) {
            valorTotal += e.calcularEntrega();
        }
        System.out.println("\nVALOR TOTAL: R$ " + String.format("%.2f", valorTotal));
    }
}
