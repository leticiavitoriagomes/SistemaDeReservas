package servicos;

import entidades.Usuario;
import entidades.Aluno;
import entidades.Servidor;
import java.util.ArrayList;
import java.util.List;

public class ServicoUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionar(Usuario u) {
        usuarios.add(u);
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public void remover(String matricula) {
        usuarios.removeIf(u -> {
            String m = (u instanceof Aluno) ? ((Aluno) u).getMatricula()
                    : ((Servidor) u).getMatriculaInstitucional();
            return m.equalsIgnoreCase(matricula.trim());
        });
    }
}
