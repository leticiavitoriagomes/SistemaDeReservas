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
            String equip = JOptionPane.showInputDialog("Adicionar equipamento:").trim();
            if (equip.isEmpty()) break;
            espaco.adicionarEquipamento(new Equipamento(equip));
        }

        gerEspacos.adicionar(espaco);
    }

    public void listarEspacos() {
        StringBuilder sb = new StringBuilder();
        for (EspacoFisico e : gerEspacos.listar()) {
            sb.append(e.getTipo()).append(" em ").append(e.getLocalizacao())
                    .append("\nCapacidade: ").append(e.getCapacidade()).append("\n---------------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.isEmpty() ? "Sem espaços!" : sb.toString());
    }

    public void excluirEspaco() throws CampoObrigatorioException {
        gerEspacos.remover(getCampo("Localização do espaço a excluir"));
    }
}
