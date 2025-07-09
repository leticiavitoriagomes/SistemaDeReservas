package testes;

import entidades.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Teste{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Semestre: ");
        String semestre = scanner.nextLine();

        Aluno aluno = new Aluno(nome, email, telefone, senha, curso, matricula, semestre);

        System.out.println("\n Cadastro de Laboratório");
        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();

        System.out.print("Capacidade: ");
        int capacidade = Integer.parseInt(scanner.nextLine());

        Laboratorio lab = new Laboratorio(localizacao, capacidade);


        System.out.println("\nDados da Reserva");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.print("Data e hora de início (dd/MM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Data e hora de fim (dd/MM/yyyy HH:mm): ");
        LocalDateTime fim = LocalDateTime.parse(scanner.nextLine(), formatter);

        Reserva reserva = new Reserva(aluno, lab, inicio, fim);


        System.out.println("Usuário: " + reserva.getUsuario().getNome());
        System.out.println("Espaço: " + reserva.getEspaco().getTipo() + " - " + reserva.getEspaco().getLocalizacao());
        System.out.println("Início: " + reserva.getDataHoraInicio());
        System.out.println("Fim: " + reserva.getDataHoraFim());

        scanner.close();
    }
}
