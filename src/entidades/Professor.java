package entidades;
public class Professor extends Servidor {
    private String cursoMinistrado;
    private CargoAcademico cargoAcademico;
    public Professor(String nome, String email, String telefone, String senha, String matriculaInstitucional, String cursoMinistrado, CargoAcademico cargoAcademico) {
        super(nome, email, telefone, senha, matriculaInstitucional);
        this.cursoMinistrado = cursoMinistrado.trim();
        this.cargoAcademico = cargoAcademico;
    }
    public String getCursoMinistrado() {
        return cursoMinistrado;
    }
    public CargoAcademico getCargoAcademico() {
        return cargoAcademico;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCurso Ministrado: " + cursoMinistrado +
                "\nCargo Acadêmico: " + cargoAcademico;
    }

}