package entidades;

public class Tecnico extends Servidor {

    private CargoTecnico cargoTecnico;
    protected String departamento;

    public Tecnico(String nomeCompleto, String emailInstitucional, String telefone, String senha, String matriculaInstitucional, CargoTecnico cargoTecnico, String departamento) {
        super(nomeCompleto, emailInstitucional, telefone, senha, matriculaInstitucional, cargoTecnico, departamento);
        this.departamento = departamento;
        this.cargoTecnico = cargoTecnico;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public CargoTecnico getCargoTecnico() {
        return cargoTecnico;
    }

    public void setCargoTecnico(CargoTecnico cargoTecnico) {
        this.cargoTecnico = cargoTecnico;
    }

    public String toString() {
        return super.toString();
            "\n Departamento: " + this.departamento +
                    "\n Cargo Técnico: " + this.cargoTecnico;
    }
}
    enum CargoTecnico {
        ADMINISTRADOR("Administrador"),
        ASSISTENTE_ADMINISTRACAO("Assistente em Administração"),
        TECNICO_CONTABILIDADE("Técnico em Conabilidade"),
        TECNICO_TI("Técnico em TI"),
        VIGILANTE("Vigilante");

        private final String selecaoCargoTecnico;
        CargoTecnico(String selecaoCargoTecnico){
            this.selecaoCargoTecnico = selecaoCargoTecnico;
        }

        @Override
        public String toString(){
            return selecaoCargoTecnico;
        }
    }
