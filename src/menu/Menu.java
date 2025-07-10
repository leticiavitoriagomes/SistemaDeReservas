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
        JFrame frame = new JFrame("Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel cadastrarLabel = new JLabel("Cadastrar");
        cadastrarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrarLabel);

        addButton(panel, "Cadastrar Usuário", () -> menuUsuario.cadastrarUsuario());
        addButton(panel, "Cadastrar Espaço", () -> menuEspaco.cadastrarEspaco());
        addButton(panel, "Agendar Reserva", () -> menuReserva.agendarReserva());

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JSeparator());
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel listarLabel = new JLabel("Listar");
        listarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listarLabel);

        addButton(panel, "Usuários Cadastrados", () -> menuUsuario.listarUsuarios());
        addButton(panel, "Espaços Cadastrados", () -> menuEspaco.listarEspacos());
        addButton(panel, "Reservas Cadastradas", () -> menuReserva.listarReservas());

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JSeparator());
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel excluirLabel = new JLabel("Excluir");
        excluirLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(excluirLabel);

        addButton(panel, "Excluir Usuário", () -> menuUsuario.excluirUsuario());
        addButton(panel, "Excluir Espaço", () -> menuEspaco.excluirEspaco());
        addButton(panel, "Excluir Reserva", () -> menuReserva.excluirReserva());

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JSeparator());
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        addButton(panel, "Sair", () -> System.exit(0));

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @FunctionalInterface
    private interface AcaoComExcecao {
        void executar() throws CampoObrigatorioException;
    }

    private static void addButton(JPanel panel, String texto, AcaoComExcecao action) {
        JButton button = new JButton(texto);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        button.addActionListener(e -> {
            try {
                action.executar();
            } catch (CampoObrigatorioException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
    }
}