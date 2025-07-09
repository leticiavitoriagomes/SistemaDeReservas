package menu;

import entidades.*;
import excecoes.CampoObrigatorioException;
import servicos.ServicoUsuario;

import javax.swing.*;

public class MenuUsuarios {
    private final ServicoUsuario gerUsuarios;

    public MenuUsuarios(ServicoUsuario gerUsuarios) {
        this.gerUsuarios = gerUsuarios;
    }

    private String getCampo(String label) throws CampoObrigatorioException {
        String input = JOptionPane.showInputDialog(label).trim();
        if (input.isEmpty()) throw new CampoObrigatorioException(label + " é obrigatório!");
        return input;
    }

    public void cadastrarUsuario() throws CampoObrigatorioException {
        String[] tipos = {"Aluno", "Professor", "Técnico"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de usuário:", "Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

        String nome = getCampo("Nome completo");
        String email = getCampo("Email institucional");
        String telefone = getCampo("Telefone");
        String senha = getCampo("Senha");

        switch (tipo) {
            case 0 -> {
                String curso = getCampo("Curso");
                String matricula = getCampo("Matrícula");
                String semestre = getCampo("Semestre em que foi matriculado (ex: 24.1)");
                gerUsuarios.adicionar(new Aluno(nome, email, telefone, senha, curso, matricula, semestre));
            }
            case 1 -> {
                String matriculaInst = getCampo("Matrícula Institucional");
                String cursoMinistrado = getCampo("Curso Ministrado");
                String[] cargos = {"AUXILIAR", "ASSISTENTE", "ADJUNTO", "ASSOCIADO", "TITULAR"};
                int c = JOptionPane.showOptionDialog(null, "Cargo Acadêmico:", "Cargo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, cargos, cargos[0]);
                CargoAcademico cargo = CargoAcademico.valueOf(cargos[c]);
                gerUsuarios.adicionar(new Professor(nome, email, telefone, senha, matriculaInst, cursoMinistrado, cargo));
            }
            case 2 -> {
                String matriculaInst = getCampo("Matrícula Institucional");
                String[] funcoes = {"ADMINISTRADOR", "ASSISTENTE", "TECNICO_CONTABILIDADE", "TECNICO_TI", "VIGILANTE"};
                int f = JOptionPane.showOptionDialog(null, "Função Técnica:", "Função", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, funcoes, funcoes[0]);
                FuncaoTecnica funcao = FuncaoTecnica.valueOf(funcoes[f]);
                String departamento = getCampo("Departamento");
                gerUsuarios.adicionar(new TecnicoAdministrativo(nome, email, telefone, senha, matriculaInst, funcao, departamento));
            }
        }
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario u : gerUsuarios.listar()) {
            String matricula = (u instanceof Aluno) ? ((Aluno) u).getMatricula() :
                    ((Servidor) u).getMatriculaInstitucional();
            sb.append("Nome: ").append(u.getNome())
                    .append("\nEmail: ").append(u.getEmail())
                    .append("\nTelefone: ").append(u.getTelefone())
                    .append("\nMatrícula: ").append(matricula).append("\n---------------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.isEmpty() ? "Sem usuários!" : sb.toString());
    }

    public void excluirUsuario() throws CampoObrigatorioException {
        String matricula = getCampo("Matrícula do usuário a excluir");
        String senha = getCampo("Senha do usuário");

        Usuario usuario = gerUsuarios.listar().stream()
                .filter(u -> {
                    String m = (u instanceof Aluno) ? ((Aluno) u).getMatricula() :
                            (u instanceof Servidor) ? ((Servidor) u).getMatriculaInstitucional() : null;
                    return m != null && m.equalsIgnoreCase(matricula.trim()) && u.getSenha().equals(senha.trim());
                })
                .findFirst()
                .orElse(null);

        if (usuario != null) {
            gerUsuarios.remover(matricula);
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado ou senha incorreta!");
        }
    }

}
