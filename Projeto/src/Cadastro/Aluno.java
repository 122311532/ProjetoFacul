package Cadastro;

// Classe Aluno (Herança de Pessoa)
public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String matricula, String nome, String endereco, String email, String celular) {
        super(nome, endereco, email, celular);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}