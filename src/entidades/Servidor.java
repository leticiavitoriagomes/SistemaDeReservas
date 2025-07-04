package entidades;

public class Servidor extends Usuario {
    private String matriculaInstitucional;

    public String getMatriculaInstitucional() {
        return matriculaInstitucional;
    }
    public void setMatriculaInstitucional() {
        this.matriculaInstitucional = matriculaInstitucional;
    }

    public Servidor (String nomeCompleto, String emailInstitucional, String telefone, String senha, String matriculaInstitucional, CargoProfessor cargo) {
        super(nomeCompleto, emailInstitucional, telefone, senha);
        this.matriculaInstitucional = matriculaInstitucional;
    }
}
