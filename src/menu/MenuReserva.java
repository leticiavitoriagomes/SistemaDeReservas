package menu;

import entidades.*;
import excecoes.CampoObrigatorioException;
import servicos.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuReserva {
    private final ServicoUsuario gerUsuarios;
    private final ServicoEspacoFisico gerEspacos;
    private final ServicoReserva gerReservas;


    public MenuReserva(ServicoUsuario gerUsuarios, ServicoEspacoFisico gerEspacos, ServicoReserva gerReservas) {
        this.gerUsuarios = gerUsuarios;
        this.gerEspacos = gerEspacos;
        this.gerReservas = gerReservas;
    }

    private String getCampo(String label) throws CampoObrigatorioException {
        String input = JOptionPane.showInputDialog(label).trim();
        if (input.isEmpty()) throw new CampoObrigatorioException(label + " é obrigatório!");
        return input;
    }

    public void agendarReserva() throws CampoObrigatorioException {
        if (gerUsuarios.listar().isEmpty() || gerEspacos.listar().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre usuários e espaços primeiro!");
            return;
        }

        String matricula = getCampo("Matrícula para Login");
        String senha = getCampo("Senha");

        Usuario usuario = gerUsuarios.listar().stream().filter(u -> {
            String m = (u instanceof Aluno) ? ((Aluno) u).getMatricula() :
                    (u instanceof Servidor) ? ((Servidor) u).getMatriculaInstitucional() : "";
            return m.equalsIgnoreCase(matricula.trim()) && u.getSenha().equals(senha.trim());
        }).findFirst().orElse(null);

        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gerEspacos.listar().size(); i++) {
            sb.append(i).append(" - ").append(gerEspacos.listar().get(i).getTipo())
                    .append(" em ").append(gerEspacos.listar().get(i).getLocalizacao()).append("\n");
        }

        int index = Integer.parseInt(getCampo("Escolha o índice do espaço:\n" + sb));
        EspacoFisico espaco = gerEspacos.listar().get(index);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(getCampo("Início (dd/MM/yyyy HH:mm)"), formatter);
        LocalDateTime fim = LocalDateTime.parse(getCampo("Fim (dd/MM/yyyy HH:mm)"), formatter);

        try {
            gerReservas.agendar(new Reserva(usuario, espaco, inicio, fim));
            JOptionPane.showMessageDialog(null, "Reserva realizada!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public void listarReservas() {
        StringBuilder sb = new StringBuilder();
        for (Reserva r : gerReservas.getTodasReservas()) {
            sb.append("Usuário: ").append(r.getUsuario().getNome()).append("\nEspaço: ")
                    .append(r.getEspaco().getTipo()).append("\nInício: ").append(r.getDataHoraInicio())
                    .append("\nFim: ").append(r.getDataHoraFim()).append("\n---------------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.isEmpty() ? "Sem reservas!" : sb.toString());
    }

    public void excluirReserva() throws CampoObrigatorioException {
        String matricula = getCampo("Matrícula da reserva");
        Reserva r = gerReservas.getTodasReservas().stream().filter(res -> {
            String m = (res.getUsuario() instanceof Aluno) ? ((Aluno) res.getUsuario()).getMatricula() :
                    ((Servidor) res.getUsuario()).getMatriculaInstitucional();
            return m.equalsIgnoreCase(matricula.trim());
        }).findFirst().orElse(null);
        if (r != null) {
            gerReservas.removerReserva(r);
        } else {
            JOptionPane.showMessageDialog(null, "Reserva não encontrada!");
        }
    }
}
