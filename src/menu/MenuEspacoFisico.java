package menu;

import entidades.*;
import excecoes.CampoObrigatorioException;
import servicos.ServicoEspacoFisico;
import servicos.ServicoReserva;

import javax.swing.*;

public class MenuEspacoFisico {
    private final ServicoEspacoFisico gerEspacos;

    public MenuEspacoFisico(ServicoEspacoFisico gerEspacos) {
        this.gerEspacos = gerEspacos;
    }

    private String getCampo(String label) throws CampoObrigatorioException {
        String input = JOptionPane.showInputDialog(label).trim();
        if (input.isEmpty()) throw new CampoObrigatorioException(label + " é obrigatório!");
        return input;
    }

    public void cadastrarEspaco() throws CampoObrigatorioException {
        String[] tipos = {"Sala de Aula", "Laboratório", "Sala de Estudos"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de Espaço:", "Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

        String localizacao = getCampo("Localização");
        int capacidade = Integer.parseInt(getCampo("Capacidade"));

        EspacoFisico espaco = switch (tipo) {
            case 0 -> new SalaDeAula(localizacao, capacidade);
            case 1 -> new Laboratorio(localizacao, capacidade);
            case 2 -> new SalaDeEstudos(localizacao, capacidade);
            default -> null;
        };

        while (true) {
            String equip = JOptionPane.showInputDialog("Adicionar equipamento (ou deixe em branco para parar):");
            if (equip == null || equip.trim().isEmpty()) break;
            espaco.adicionarEquipamento(new Equipamento(equip.trim()));
        }

        gerEspacos.adicionar(espaco);
        JOptionPane.showMessageDialog(null, "Espaço cadastrado com sucesso!");
    }

    public void listarEspacos() {
        StringBuilder sb = new StringBuilder();
        for (EspacoFisico e : gerEspacos.listar()) {
            sb.append(e.getTipo()).append(" em ").append(e.getLocalizacao())
                    .append("\nCapacidade: ").append(e.getCapacidade());

            // Lista os equipamentos do espaço
            if (e.getEquipamentos().isEmpty()) {
                sb.append("\nEquipamentos: Nenhum");
            } else {
                sb.append("\nEquipamentos:");
                for (Equipamento eq : e.getEquipamentos()) {
                    sb.append("\n - ").append(eq.getNome());
                }
            }

            sb.append("\n---------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.isEmpty() ? "Sem espaços!" : sb.toString());
    }


    public void excluirEspaco() {
        if (gerEspacos.listar().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há espaços cadastrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gerEspacos.listar().size(); i++) {
            EspacoFisico e = gerEspacos.listar().get(i);
            sb.append(i).append(" - ")
                    .append(e.getTipo()).append(" em ")
                    .append(e.getLocalizacao()).append("\n");
        }

        try {
            String entrada = JOptionPane.showInputDialog("Escolha o número do espaço que deseja excluir:\n" + sb.toString());
            if (entrada == null || entrada.trim().isEmpty()) return;

            int indice = Integer.parseInt(entrada.trim());
            if (indice >= 0 && indice < gerEspacos.listar().size()) {
                EspacoFisico espaco = gerEspacos.listar().get(indice);
                gerEspacos.remover(espaco.getLocalizacao());
                JOptionPane.showMessageDialog(null, "Espaço excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número.");
        }
    }

}
