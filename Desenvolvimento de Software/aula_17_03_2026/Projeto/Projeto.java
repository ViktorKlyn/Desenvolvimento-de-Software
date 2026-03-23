import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner selecione = new Scanner(System.in);
        Scanner quantidade = new Scanner(System.in);

        int opcao;
        double soma;
        double valor;

        System.out.println("--- Lojas Tech --- ");
        System.out.println("Opcoes: ");
        System.out.println("Ver produtos - [1]");
        System.out.println("Comprar ------ [2]");
        System.out.println("Finaliza ----- [3]");
        System.out.print(" : ");
        opcao = entrada.nextInt();

        double precoCelular = 4.000, precoFone = 500, precoNotebook = 5.000;
        String nomeCelular = "Iphone 17", nomeFone = "Air Pods", nomeNotebook = "MacBook";

        switch (opcao) {
            case 1:
                System.out.println("Nossos produtos em estoque:");
                System.out.println(nomeCelular);
                System.out.println(nomeFone);
                System.out.println(nomeNotebook);
                break;
                case 2:
                System.out.println("Precos: ");
                System.out.println("[1] - " + nomeCelular + " : " + precoCelular);
                System.out.println("[2] - " + nomeFone + " : " + precoFone);
                System.out.println("[3] - " + nomeNotebook + " : " + precoNotebook);
                System.out.println("[4] - Comprar mais de um produto");
                System.out.print("Selecione: ");
                int escolher = selecione.nextInt();

                if(escolher == 1){
                    System.out.println("Quantidade: ");
                    int comprar = quantidade.nextInt();
                    
                }
                if(escolher == 2){
                    System.out.println("Quantidade: ");
                    int comprar = quantidade.nextInt();
                }
                if(escolher == 3){
                    System.out.println("Quantidade: ");
                    int comprar = quantidade.nextInt();
                }
                if(escolher == 4){
                    System.out.println("Quantidade: ");
                    int comprar = quantidade.nextInt();
                }
                break;
            case 3:
            System.out.println("Programa encerrado!");
                break;
            default:
            System.out.println("Opcao invalida!");
                throw new AssertionError();
        }
    }
}