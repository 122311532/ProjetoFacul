import java.util.Scanner;
import Menus.Alunos;
import Menus.Professores;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        boolean continuar = true;
        while (continuar) {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Alunos");
            System.out.println("2 - Professores");
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
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
