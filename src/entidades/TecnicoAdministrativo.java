package entidades;
public class TecnicoAdministrativo extends Servidor {
    private FuncaoTecnica funcao;
    private String departamento;
    public TecnicoAdministrativo(String nome, String email, String telefone, String senha, String matriculaInstitucional, FuncaoTecnica funcao, String departamento) {
        super(nome, email, telefone, senha, matriculaInstitucional);
        this.funcao = funcao;
        this.departamento = departamento.trim();
    }
    public FuncaoTecnica getFuncao() {
        return funcao;
    }
    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFunção Técnica: " + funcao +
                "\nDepartamento: " + departamento;
    }

}