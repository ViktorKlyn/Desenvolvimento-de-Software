import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PlanoAcademia {
    private String nomeAluno;
    private double valorMensal;
    private int anosNoPlano;
    private static final double MAX_DESCONTO = 0.20;

    public PlanoAcademia(String nomeAluno, double valorMensal, int anosNoPlano) {
        this.nomeAluno = nomeAluno;
        this.valorMensal = valorMensal;
        this.anosNoPlano = anosNoPlano;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public int getAnosNoPlano() {
        return anosNoPlano;
    }

    protected double calcularDesconto() {
        if (anosNoPlano >= 5) {
            return MAX_DESCONTO;
        }
        if (anosNoPlano >= 3) {
            return 0.10;
        }
        if (anosNoPlano >= 1) {
            return 0.05;
        }
        return 0.0;
    }

    public double calcularMensalidadeComDesconto() {
        double mensalidade = calcularMensalidade();
        double desconto = calcularDesconto();
        return mensalidade - (mensalidade * desconto);
    }

    public abstract double calcularMensalidade();

    public void mostrarResumo() {
        double mensalidade = calcularMensalidade();
        double desconto = calcularDesconto();
        double total = calcularMensalidadeComDesconto();
        System.out.println("Aluno: " + nomeAluno
                + " | Plano: " + this.getClass().getSimpleName()
                + " | Mensalidade: R$ " + String.format("%.2f", mensalidade)
                + " | Desconto: " + String.format("%.0f%%", desconto * 100)
                + " | Total: R$ " + String.format("%.2f", total));
    }
}

class PlanoBasico extends PlanoAcademia {
    public PlanoBasico(String nomeAluno, double valorMensal, int anosNoPlano) {
        super(nomeAluno, valorMensal, anosNoPlano);
    }

    @Override
    public double calcularMensalidade() {
        return getValorMensal();
    }
}

class PlanoPremium extends PlanoAcademia {
    private static final double ADICIONAL_PERSONAL = 50.0;

    public PlanoPremium(String nomeAluno, double valorMensal, int anosNoPlano) {
        super(nomeAluno, valorMensal, anosNoPlano);
    }

    @Override
    public double calcularMensalidade() {
        return getValorMensal() + ADICIONAL_PERSONAL;
    }
}

class PlanoVIP extends PlanoAcademia {
    private static final double ADICIONAL_PERSONAL = 50.0;
    private static final double ADICIONAL_NUTRICAO = 40.0;

    public PlanoVIP(String nomeAluno, double valorMensal, int anosNoPlano) {
        super(nomeAluno, valorMensal, anosNoPlano);
    }

    @Override
    public double calcularMensalidade() {
        return getValorMensal() + ADICIONAL_PERSONAL + ADICIONAL_NUTRICAO;
    }
}

public class Exe4 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<PlanoAcademia> planos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = readInt();
            switch (opcao) {
                case 1:
                    cadastrarPlano();
                    break;
                case 2:
                    listarPlanos();
                    break;
                case 3:
                    mostrarTotalMensalidades();
                    break;
                case 4:
                    mostrarResumoDosPlanos();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE ACADEMIA ===");
        System.out.println("1. Cadastrar plano");
        System.out.println("2. Listar planos");
        System.out.println("3. Mostrar valor total de mensalidades");
        System.out.println("4. Mostrar resumo dos planos");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarPlano() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Valor base da mensalidade: R$ ");
        double valor = readDouble();

        System.out.print("Tempo no plano (anos): ");
        int anos = readInt();

        System.out.println("Tipo de plano:");
        System.out.println("1. Plano Básico");
        System.out.println("2. Plano Premium (+ personal trainer)");
        System.out.println("3. Plano VIP (+ personal + nutrição)");
        System.out.print("Escolha o tipo: ");
        int tipo = readInt();

        PlanoAcademia plano;
        switch (tipo) {
            case 1:
                plano = new PlanoBasico(nome, valor, anos);
                break;
            case 2:
                plano = new PlanoPremium(nome, valor, anos);
                break;
            case 3:
                plano = new PlanoVIP(nome, valor, anos);
                break;
            default:
                System.out.println("Tipo inválido. Cadastro cancelado.");
                return;
        }
        planos.add(plano);
        System.out.println("Plano cadastrado com sucesso!");
    }

    private static void listarPlanos() {
        if (planos.isEmpty()) {
            System.out.println("Nenhum plano cadastrado.");
            return;
        }
        System.out.println("\n=== PLANOS CADASTRADOS ===");
        for (int i = 0; i < planos.size(); i++) {
            PlanoAcademia plano = planos.get(i);
            System.out.println((i + 1) + ". " + plano.getNomeAluno()
                    + " - " + plano.getClass().getSimpleName()
                    + " - R$ " + String.format("%.2f", plano.calcularMensalidadeComDesconto()));
        }
    }

    private static void mostrarTotalMensalidades() {
        if (planos.isEmpty()) {
            System.out.println("Nenhum plano cadastrado.");
            return;
        }
        double total = 0;
        for (PlanoAcademia plano : planos) {
            total += plano.calcularMensalidadeComDesconto();
        }
        System.out.println("\nValor total das mensalidades: R$ " + String.format("%.2f", total));
    }

    private static void mostrarResumoDosPlanos() {
        if (planos.isEmpty()) {
            System.out.println("Nenhum plano cadastrado.");
            return;
        }
        System.out.println("\n=== RESUMO DOS PLANOS ===");
        for (PlanoAcademia plano : planos) {
            plano.mostrarResumo();
        }
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Valor inválido. Digite um número inteiro:");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido. Digite um número válido:");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
