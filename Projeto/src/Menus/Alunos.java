package Menus;

import java.util.List;
import java.util.Scanner;
import Cadastro.Aluno;
import Controllers.AlunoController;

public class Alunos {
    public static void executarMenuAlunos() {
        AlunoController alunoController = new AlunoController();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Pesquisar alunos");
            System.out.println("3 - Listar alunos");
            System.out.println("4 - Remover aluno");
            System.out.println("0 - Sair");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarAluno(scanner, alunoController);
                    break;
                case "2":
                    pesquisarAlunos(scanner, alunoController);
                    break;
                case "3":
                    listarAlunos(alunoController);
                    break;
                case "4":
                    removerAluno(scanner, alunoController);
                    break;
                case "0":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));
    }

    private static void cadastrarAluno(Scanner scanner, AlunoController alunoController) {
        System.out.println("Digite a matrícula do aluno:");
        String matricula = scanner.nextLine();
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o email do aluno:");
        String email = scanner.nextLine();
        System.out.println("Digite o celular do aluno:");
        String celular = scanner.nextLine();

        Aluno aluno = new Aluno(matricula, nome, endereco, email, celular);
        alunoController.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private static void pesquisarAlunos(Scanner scanner, AlunoController alunoController) {
        System.out.println("Digite a matrícula do aluno que deseja pesquisar:");
        String matriculaPesquisa = scanner.nextLine();
        Aluno alunoEncontrado = alunoController.buscarAlunoPorMatricula(matriculaPesquisa);
        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado: " + alunoEncontrado.getNome());
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    private static void listarAlunos(AlunoController alunoController) {
        List<Aluno> listaAlunos = alunoController.listarAlunos();
        if (!listaAlunos.isEmpty()) {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : listaAlunos) {
                System.out.println(aluno.getNome());
            }
        } else {
            System.out.println("Nenhum aluno cadastrado");
        }
    }

    private static void removerAluno(Scanner scanner, AlunoController alunoController) {
        System.out.println("Digite a matrícula do aluno que deseja remover:");
        String matriculaRemocao = scanner.nextLine();
        alunoController.removerAluno(matriculaRemocao);
        System.out.println("Aluno removido com sucesso.");
    }
}
