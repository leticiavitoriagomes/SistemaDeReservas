package entidades;

public class Usuario {

        private static int proximoId = 1;
        private final int id;
        private String nomeCompleto;
        private String emailInstitucional;
        private String telefone;
        private String senha;


    public Usuario(String nomeCompleto, String emailInstitucional, String telefone, String senha) {

        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Nome completo' é obrigatório.");
        }
        if (emailInstitucional == null || emailInstitucional.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Email institucional' é obrigatório.");
        }
        this.id = proximoId++;
        this.nomeCompleto = nomeCompleto;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.senha = senha;
    }


    public String getNomeCompleto(){
            return nomeCompleto;
        }
        public void setNomeCompleto(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }

        public String getEmailInstitucinal(){
            return emailInstitucional;
        }
        public void setEmailInstitucinal(String emailInstitucinal){
            this.emailInstitucional = emailInstitucional;
        }

        public String getTelefone(){
            return telefone;
        }
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getSenha() {
            return senha;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }

        @Override
        public String toString(){
            return "Nome: " + this.nomeCompleto +
                    "\n emailInstitucional: " + this.emailInstitucional +
                    "\n telefone: " + this.telefone +
                    "\n senha: " + this.senha;
        }
}

