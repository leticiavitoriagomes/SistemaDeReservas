    package servicos;

    import entidades.EspacoFisico;
    import java.util.ArrayList;
    import java.util.List;

    public class ServicoEspacoFisico {
        private List<EspacoFisico> espacos = new ArrayList<>();

        public void adicionar(EspacoFisico e) {
            espacos.add(e);
        }

        public List<EspacoFisico> listar() {
            return espacos;
        }

        public void remover(String local) {
            espacos.removeIf(e -> e.getLocalizacao().equalsIgnoreCase(local.trim()));
        }
    }
