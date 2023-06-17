package Cadastro;

// Classe Professor (Herança de Pessoa)
public class Professor extends Pessoa {
    private String cpf;

    public Professor(String cpf, String nome, String endereco, String email, String celular) {
        super(nome, endereco, email, celular);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
