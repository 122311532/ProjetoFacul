import java.util.Scanner;
import Menus.Alunos;
import Menus.Professores;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Alunos");
            System.out.println("2 - Outra opção");
            System.out.println("0 - Sair");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    Alunos.executarMenuAlunos();
                    break;
                case "2":
                    Professores.executarMenuProfessores();
                    break;
                case "0":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));

        scanner.close();
    }
}
