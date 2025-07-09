package testes;

import entidades.*;
import servicos.ServicoUsuario;

import java.util.Scanner;

public class TesteServicoUsuario {
    public static void main(String[] args) {
        ServicoUsuario servico = new ServicoUsuario();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Técnico Administrativo");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Remover Usuário por Matrícula");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome completo: ");
                    String nome = sc.nextLine();
                    System.out.print("Email institucional: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = sc.nextLine();

                    Aluno aluno = new Aluno(nome, email, telefone, senha, curso, matricula, semestre);
                    servico.adicionar(aluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Nome completo: ");
                    String nome = sc.nextLine();
                    System.out.print("Email institucional: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    System.out.print("Matrícula Institucional: ");
                    String matriculaInst = sc.nextLine();
                    System.out.print("Curso ministrado: ");
                    String curso = sc.nextLine();
                    System.out.println("Cargo acadêmico (AUXILIAR, ASSISTENTE, ADJUNTO, ASSOCIADO, TITULAR): ");
                    CargoAcademico cargo = CargoAcademico.valueOf(sc.nextLine().toUpperCase());

                    Professor prof = new Professor(nome, email, telefone, senha, matriculaInst, curso, cargo);
                    servico.adicionar(prof);
                    System.out.println("Professor cadastrado com sucesso!");
                }
                case 3 -> {
                    System.out.print("Nome completo: ");
                    String nome = sc.nextLine();
                    System.out.print("Email institucional: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    System.out.print("Matrícula Institucional: ");
                    String matriculaInst = sc.nextLine();
                    System.out.println("Função técnica (ADMINISTRADOR, ASSISTENTE, TECNICO_CONTABILIDADE, TECNICO_TI, VIGILANTE): ");
                    FuncaoTecnica funcao = FuncaoTecnica.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Departamento: ");
                    String departamento = sc.nextLine();

                    TecnicoAdministrativo tecnico = new TecnicoAdministrativo(nome, email, telefone, senha, matriculaInst, funcao, departamento);
                    servico.adicionar(tecnico);
                    System.out.println("Técnico cadastrado com sucesso!");
                }
                case 4 -> {
                    System.out.println("\n=== LISTA DE USUÁRIOS ===");
                    for (Usuario u : servico.listar()) {
                        String tipo = (u instanceof Aluno) ? "Aluno"
                                : (u instanceof Professor) ? "Professor"
                                : "Técnico";
                        String matricula = (u instanceof Aluno) ? ((Aluno) u).getMatricula()
                                : ((Servidor) u).getMatriculaInstitucional();
                        System.out.println("Tipo: " + tipo);
                        System.out.println("Nome: " + u.getNome());
                        System.out.println("Email: " + u.getEmail());
                        System.out.println("Matrícula: " + matricula);
                    }
                    if (servico.listar().isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Digite a matrícula do usuário a ser removido: ");
                    String matricula = sc.nextLine();
                    servico.remover(matricula);

                }
                case 0 -> {
                    System.out.println("Encerrando...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }
}
