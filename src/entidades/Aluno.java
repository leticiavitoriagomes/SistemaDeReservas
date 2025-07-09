package entidades;

public class Aluno extends Usuario {
    private String curso, matricula, semestre;
    public Aluno(String nome, String email, String telefone, String senha, String curso, String matricula, String semestre) {
        super(nome, email, telefone, senha);
        this.curso = curso.trim();
        this.matricula = matricula.trim();
        this.semestre = semestre.trim();
    }
    public String getCurso() {
        return curso;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getSemestre() {
        return semestre;
    }
}