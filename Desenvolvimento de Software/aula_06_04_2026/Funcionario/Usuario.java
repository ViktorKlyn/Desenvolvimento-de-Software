class User{
    String nome;
    String email;
    String senha;

    public User(String nome, String email, String senha){
        if(senha.length() >= 6) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        } else{
            System.out.println("Senha deve conter no mínimo 6 caracteres!");
        }
    }
}

public class Usuario{
    public static void main(String[] args) {
        User us = new User("Maria", "maria@gmail.com", "123@#$");

        System.out.println("Nome: " + us.nome);
        System.out.println("Email: " + us.email);
        System.out.println("Senha: " + us.senha);
    }
}