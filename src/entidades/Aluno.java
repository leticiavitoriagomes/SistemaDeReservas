package entidades;

public class Aluno extends Usuario {

    private String curso;
    private String matricula;
    private String semestreMatriculado;

    public Aluno (String nomeCompleto, String emailInstitucional, String telefone, String senha, String curso, String semestreMatriculado, String matricula) {
        super(nomeCompleto, emailInstitucional, telefone, senha);

        this.curso = curso;
        this.matricula = matricula;
        this.semestreMatriculado = semestreMatriculado;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getSemestreMatriculado() {
        return semestreMatriculado;
    }
    public void setSemestreMatriculado(String semestreMatriculado) {
        this.semestreMatriculado = semestreMatriculado;
    }



}
