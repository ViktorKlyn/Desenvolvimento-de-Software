package model;

/**
 * Classe abstrata que representa uma pessoa no sistema hospitalar.
 * Define os atributos básicos comuns a pacientes e funcionários.
 */
public abstract class Pessoa {
    private String id;
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Nome='" + nome + '\'' + ", CPF='" + cpf + '\'' + ", Telefone='" + telefone + '\'';
    }
}
