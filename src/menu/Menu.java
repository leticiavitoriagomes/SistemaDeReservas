package menu;

import excecoes.CampoObrigatorioException;
import servicos.*;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private static final ServicoUsuario gerUsuarios = new ServicoUsuario();
    private static final ServicoEspacoFisico gerEspacos = new ServicoEspacoFisico();
    private static final ServicoReserva gerReservas = new ServicoReserva();


    private static final MenuUsuarios menuUsuario = new MenuUsuarios(gerUsuarios);
    private static final MenuEspacoFisico menuEspaco = new MenuEspacoFisico(gerEspacos);
    private static final MenuReserva menuReserva = new MenuReserva(gerUsuarios, gerEspacos, gerReservas);

    public static void exibirMenu() {
        while (true) {
            String[] opcoes = {
                    "Cadastrar Usuário", "Cadastrar Espaço", "Agendar Reserva",
                    "Usuários Cadastrados", "Espaços Cadastrados", "Reservas Cadastradas",
                    "Excluir Usuário", "Excluir Espaço", "Excluir Reserva", "Sair"
            };

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            for (String opcao : opcoes) {
                JButton button = new JButton(opcao);
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.addActionListener(e -> {
                    try {
                        switch (opcao) {
                            case "Cadastrar Usuário" -> menuUsuario.cadastrarUsuario();
                            case "Cadastrar Espaço" -> menuEspaco.cadastrarEspaco();
                            case "Agendar Reserva" -> menuReserva.agendarReserva();
                            case "Usuários Cadastrados" -> menuUsuario.listarUsuarios();
                            case "Espaços Cadastrados" -> menuEspaco.listarEspacos();
                            case "Reservas Cadastradas" -> menuReserva.listarReservas();
                            case "Excluir Usuário" -> menuUsuario.excluirUsuario();
                            case "Excluir Espaço" -> menuEspaco.excluirEspaco();
                            case "Excluir Reserva" -> menuReserva.excluirReserva();
                            case "Sair" -> System.exit(0);
                        }
                    } catch (CampoObrigatorioException ex) {
                        JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                    }
                });
                panel.add(button);
                panel.add(Box.createRigidArea(new Dimension(0, 5))); // Espaço entre botões
            }

            JOptionPane.showMessageDialog(null, panel, "Menu Principal", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
