package entidades;

public abstract class Servidor extends Usuario {
    private String matriculaInstitucional;
    public Servidor(String nome, String email, String telefone, String senha, String matriculaInstitucional) {
        super(nome, email, telefone, senha);
        this.matriculaInstitucional = matriculaInstitucional.trim();
    }
    public String getMatriculaInstitucional() {
        return matriculaInstitucional;
    }
}