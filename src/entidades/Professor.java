package entidades;

enum CargoProfessor {
    PROFESSOR_AUXILIAR("Professor Auxiliar"),
    PROFESSOR_ASSISTENTE("Professor Assistente"),
    PROFESSOR_ADJUNTO("Professor Adjunto"),
    PROFESSOR_ASSOCIADO("Professor Associado"),
    PROFESSOR_TITULAR("Professor Titular");

    private final String selecaoCargo;
    CargoProfessor(String selecaoCargo){
        this.selecaoCargo = selecaoCargo;
    }

    @Override
    public String toString(){
        return selecaoCargo;
    }
}
public class Professor extends Servidor {

    private String curso;
    protected CargoProfessor cargo;

    public Professor(String nomeCompleto, String emailInstitucional, String telefone, String senha, String curso,
                     CargoProfessor cargo) {
        super(nomeCompleto, emailInstitucional, telefone, senha, curso, cargo);
        this.curso = curso;
        this.cargo = cargo;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public CargoProfessor getCargo() {
        return cargo;
    }
    public void setCargo(CargoProfessor cargo) {
        this.cargo = cargo;
    }

    public String toString(){
        return super.toString() +
                "\nCurso: " + this.curso +
                "\nCargo: " + this.cargo;
    }
}
