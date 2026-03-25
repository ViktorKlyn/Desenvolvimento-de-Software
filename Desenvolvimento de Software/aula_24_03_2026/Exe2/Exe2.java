import java.util.ArrayList;

class Produto {
    String produtoNome;
    double produtoPreco;
}

public class Exe2 {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto();
        produto1.produtoNome = "Celular";
        produto1.produtoPreco = 2000.0;

        Produto produto2 = new Produto();
        produto2.produtoNome = "Notebook";
        produto2.produtoPreco = 5000.0;

        Produto produto3 = new Produto();
        produto3.produtoNome = "Fone";
        produto3.produtoPreco = 200.0;

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        for(Produto p : produtos){
            System.out.println(p.produtoNome);
            System.out.println(p.produtoPreco);
        }
    }
}