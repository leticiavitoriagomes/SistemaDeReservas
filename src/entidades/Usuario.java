package entidades;

public class Usuario {
    private String nome, email, telefone, senha;
    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome.trim();
        this.email = email.trim();
        this.telefone = telefone.trim();
        this.senha = senha.trim();
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEmail: " + email + "\nTelefone: " + telefone;
    }

}

