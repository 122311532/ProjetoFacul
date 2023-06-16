package Controllers;

import java.util.ArrayList;
import java.util.List;
import Cadastro.Professor;

public class ProfessorController {
    private List<Professor> professores;

    public ProfessorController() {
        professores = new ArrayList<>();
    }

    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }

    public Professor buscarProfessorPorCPF(String cpf) {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor;
            }
        }
        return null;
    }

    public List<Professor> buscarProfessorPorNome(String nome) {
        List<Professor> professoresEncontrados = new ArrayList<>();
        for (Professor professor : professores) {
            if (professor.getNome().equals(nome)) {
                professoresEncontrados.add(professor);
            }
        }
        return professoresEncontrados;
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    public void removerProfessor(String cpf) {
        Professor professorRemover = null;
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                professorRemover = professor;
                break;
            }
        }
        if (professorRemover != null) {
            professores.remove(professorRemover);
        }
    }
}
