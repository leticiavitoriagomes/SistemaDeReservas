package entidades;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Por favor, digite as informações solicitadas.\n");

        System.out.println("Digite o nome completo: ");
        String nomeCompleto = leitor.nextLine();

        System.out.println("Digite o e-mail institucional: ");
        String emailInstitucional = leitor.nextLine();

        System.out.println("Digite o telefone: ");
        String telefone = leitor.nextLine();

        System.out.println("Crie uma senha: ");
        String senha = leitor.nextLine();

        Usuario cadastrado = new Usuario(nomeCompleto, emailInstitucional, telefone, senha);

        System.out.println("Aluno cadastrado com sucesso! Verifique os dados: ");
        System.out.println(cadastrado);

        leitor.close();

    }
}
