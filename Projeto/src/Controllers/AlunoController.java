package Controllers;
import java.util.ArrayList;
import java.util.List;
import Cadastro.Aluno;

public class AlunoController {
    private List<Aluno> listaAlunos;

    public AlunoController() {
        listaAlunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> listarAlunos() {
        return listaAlunos;
    }

    public void removerAluno(String matricula) {
        Aluno alunoRemover = null;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoRemover = aluno;
                break;
            }
        }
        if (alunoRemover != null) {
            listaAlunos.remove(alunoRemover);
        }
    }
}
