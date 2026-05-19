import java.util.ArrayList;

abstract class Conteudo {
    protected String titulo;
    protected double duracao;

    public Conteudo(String titulo, double duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    abstract double calcularValorAssinatura();

    public void mostrarInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("Valor: R$ " + String.format("%.2f", calcularValorAssinatura()));
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracao() {
        return duracao;
    }
}

class Filme extends Conteudo {
    private static final double TAXA_EXTRA = 5.0;
    private double valorBase;

    public Filme(String titulo, double duracao, double valorBase) {
        super(titulo, duracao);
        this.valorBase = valorBase;
    }

    @Override
    double calcularValorAssinatura() {
        return valorBase + TAXA_EXTRA;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("=== FILME ===");
        super.mostrarInformacoes();
        System.out.println();
    }
}

class Serie extends Conteudo {
    private int numEpisodios;
    private double valorPorEpisodio;

    public Serie(String titulo, double duracao, int numEpisodios, double valorPorEpisodio) {
        super(titulo, duracao);
        this.numEpisodios = numEpisodios;
        this.valorPorEpisodio = valorPorEpisodio;
    }

    @Override
    double calcularValorAssinatura() {
        return numEpisodios * valorPorEpisodio;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("=== SÉRIE ===");
        super.mostrarInformacoes();
        System.out.println("Número de episódios: " + numEpisodios);
        System.out.println();
    }

    public int getNumEpisodios() {
        return numEpisodios;
    }
}

class Documentario extends Conteudo {
    private double valorBase;

    public Documentario(String titulo, double duracao, double valorBase) {
        super(titulo, duracao);
        this.valorBase = valorBase;
    }

    @Override
    double calcularValorAssinatura() {
        return valorBase;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("=== DOCUMENTÁRIO ===");
        super.mostrarInformacoes();
        System.out.println();
    }
}

class PlataformaStreaming {
    private ArrayList<Conteudo> conteudos;

    public PlataformaStreaming() {
        this.conteudos = new ArrayList<>();
    }

    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
        System.out.println("✔ " + conteudo.getTitulo() + " adicionado à plataforma!");
    }

    public void removerConteudo(Conteudo conteudo) {
        conteudos.remove(conteudo);
        System.out.println("✔ " + conteudo.getTitulo() + " removido da plataforma!");
    }

    public void mostrarTodosConteudos() {
        if (conteudos.isEmpty()) {
            System.out.println("Nenhum conteúdo disponível!");
            return;
        }

        System.out.println("\n========== CATÁLOGO DA PLATAFORMA ==========\n");
        for (Conteudo conteudo : conteudos) {
            conteudo.mostrarInformacoes();
        }
    }

    public double calcularValorMedioAssinatura() {
        if (conteudos.isEmpty()) {
            return 0;
        }

        double soma = 0;
        for (Conteudo conteudo : conteudos) {
            soma += conteudo.calcularValorAssinatura();
        }

        return soma / conteudos.size();
    }

    public void mostrarValorTotal() {
        double total = 0;
        for (Conteudo conteudo : conteudos) {
            total += conteudo.calcularValorAssinatura();
        }

        System.out.println("\n========== RESUMO FINANCEIRO ==========");
        System.out.println("Valor total de assinatura: R$ " + String.format("%.2f", total));
        System.out.println("Valor médio por conteúdo: R$ " + String.format("%.2f", calcularValorMedioAssinatura()));
        System.out.println("========================================\n");
    }

    public int getTotalConteudos() {
        return conteudos.size();
    }
}

class Exe1 {
    public static void main(String[] args) {
        PlataformaStreaming plataforma = new PlataformaStreaming();

        Filme filme1 = new Filme("Inception", 148, 15.00);
        Filme filme2 = new Filme("Interestelar", 169, 15.00);

        Serie serie1 = new Serie("Breaking Bad", 47, 62, 2.00);
        Serie serie2 = new Serie("The Office", 22, 201, 1.50);

        Documentario doc1 = new Documentario("Planeta Azul", 90, 8.00);
        Documentario doc2 = new Documentario("Cosmos", 60, 6.00);

        System.out.println("========== ADICIONANDO CONTEÚDOS ==========\n");
        plataforma.adicionarConteudo(filme1);
        plataforma.adicionarConteudo(filme2);
        plataforma.adicionarConteudo(serie1);
        plataforma.adicionarConteudo(serie2);
        plataforma.adicionarConteudo(doc1);
        plataforma.adicionarConteudo(doc2);

        plataforma.mostrarTodosConteudos();

        plataforma.mostrarValorTotal();

        System.out.println("========== INFORMAÇÕES DETALHADAS ==========\n");
        filme1.mostrarInformacoes();
        serie1.mostrarInformacoes();
        doc1.mostrarInformacoes();
    }
}
