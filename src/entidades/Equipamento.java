package entidades;

public class Equipamento {
    private String nome;
    public Equipamento(String nome) { this.nome = nome.trim(); }
    public String getNome() { return nome; }
}