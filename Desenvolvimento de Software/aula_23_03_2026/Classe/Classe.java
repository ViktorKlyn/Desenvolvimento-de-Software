class Classe {
    String nome;
    int idade;
    String curso;
    String cpf;

    void apresentar() {
        System.out.println("Meu nome eh: " + nome);
        System.out.println("Minha idade eh: " + idade);
        System.out.println("Meu curso eh: " + curso);
        System.out.println("O numero do meu cpf eh: " + cpf);
    }

    void estudar() {
        System.out.println("O aluno esta estudando!");
    }

    public static void main(String[] args) {
        Classe aluno1 = new Classe();

        aluno1.nome = "Maria Eduarda";
        aluno1.idade = 34;
        aluno1.curso = "ADS";
        aluno1.cpf = "4327894327";

        aluno1.apresentar();
        aluno1.estudar();
    }
}