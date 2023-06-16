package Cadastro;

class Pessoa {
    private String nome;
    private String endereco;
    private String email;
    private String celular;

   
    public Pessoa(String nome, String endereco, String email, String celular) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }
}


