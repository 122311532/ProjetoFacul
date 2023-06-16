package Menus;

import java.util.List;
import java.util.Scanner;
import Cadastro.Professor;
import Controllers.ProfessorController;

public class Professores {
    public static void executarMenuProfessores() {
        ProfessorController professorController = new ProfessorController();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Cadastrar professor");
            System.out.println("2 - Pesquisar professor por CPF");
            System.out.println("3 - Pesquisar professor por nome");
            System.out.println("4 - Listar professores");
            System.out.println("5 - Remover professor");
            System.out.println("0 - Sair");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarProfessor(scanner, professorController);
                    break;
                case "2":
                    pesquisarProfessorPorCPF(scanner, professorController);
                    break;
                case "3":
                    pesquisarProfessorPorNome(scanner, professorController);
                    break;
                case "4":
                    listarProfessores(professorController);
                    break;
                case "5":
                    removerProfessor(scanner, professorController);
                    break;
                case "0":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));
    }

    private static void cadastrarProfessor(Scanner scanner, ProfessorController professorController) {
        System.out.println("Digite o nome do professor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do professor:");
        String cpf = scanner.nextLine();

        Professor professor = new Professor(cpf, nome, "", "", ""); // Altere as informações de endereço, email e celular conforme necessário
        professorController.cadastrarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso.");
    }

    private static void pesquisarProfessorPorCPF(Scanner scanner, ProfessorController professorController) {
        System.out.println("Digite o CPF do professor que deseja pesquisar:");
        String cpfPesquisa = scanner.nextLine();
        Professor professorEncontrado = professorController.buscarProfessorPorCPF(cpfPesquisa);
        if (professorEncontrado != null) {
            System.out.println("Professor encontrado: " + professorEncontrado.getNome());
        } else {
            System.out.println("Professor não encontrado");
        }
    }

    private static void pesquisarProfessorPorNome(Scanner scanner, ProfessorController professorController) {
        System.out.println("Digite o nome do professor que deseja pesquisar:");
        String nomePesquisa = scanner.nextLine();
        List<Professor> professoresEncontrados = professorController.buscarProfessorPorNome(nomePesquisa);
        if (!professoresEncontrados.isEmpty()) {
            System.out.println("Professores encontrados:");
            for (Professor professor : professoresEncontrados) {
                System.out.println(professor.getNome());
            }
        } else {
            System.out.println("Nenhum professor encontrado");
        }
    }

    private static void listarProfessores(ProfessorController professorController) {
        List<Professor> listaProfessores = professorController.listarProfessores();
        if (!listaProfessores.isEmpty()) {
            System.out.println("Lista de professores:");
            for (Professor professor : listaProfessores) {
                System.out.println(professor.getNome());
            }
        } else {
            System.out.println("Nenhum professor cadastrado");
        }
    }

    private static void removerProfessor(Scanner scanner, ProfessorController professorController) {
        System.out.println("Digite o CPF do professor que deseja remover:");
        String cpfRemocao = scanner.nextLine();
        professorController.removerProfessor(cpfRemocao);
        System.out.println("Professor removido com sucesso.");
    }
}
