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

       boolean continuar = true;
        while (continuar) {
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
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }

    private static void cadastrarProfessor(Scanner scanner, ProfessorController professorController) {
        System.out.println("Digite o nome do professor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do professor:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o email do aluno:");
        String email = scanner.nextLine();
        System.out.println("Digite o celular do aluno:");
        String celular = scanner.nextLine();

        Professor professor = new Professor(cpf, nome,endereco, email, celular); // Altere as informações de endereço, email e celular conforme necessário
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
            System.out.println("---------------------------------------------------------");

            // Definindo a matriz para a tabela
            String[][] tabela = new String[listaProfessores.size() + 1][5];

            // Preenchendo a primeira linha com os cabeçalhos
            tabela[0] = new String[]{"Nome", "CPF", "Endereço", "Email", "Celular"};

            // Preenchendo as demais linhas com os dados dos professores
            for (int i = 0; i < listaProfessores.size(); i++) {
                Professor professor = listaProfessores.get(i);
                tabela[i + 1] = new String[]{
                        professor.getNome(), professor.getCpf(), professor.getEndereco(),
                        professor.getEmail(), professor.getCelular()
                };
            }

            // Definindo o tamanho máximo de cada coluna
            int[] tamanhoColunas = new int[5];
            for (int i = 0; i < tabela.length; i++) {
                for (int j = 0; j < tabela[i].length; j++) {
                    int tamanhoCampo = tabela[i][j].length();
                    if (tamanhoCampo > tamanhoColunas[j]) {
                        tamanhoColunas[j] = tamanhoCampo;
                    }
                }
            }

            // Imprimindo a tabela
            for (int i = 0; i < tabela.length; i++) {
                for (int j = 0; j < tabela[i].length; j++) {
                    System.out.printf("| %-"+(tamanhoColunas[j]+2)+"s", tabela[i][j]);
                }
                System.out.println("|");
            }

            System.out.println("---------------------------------------------------------");
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
