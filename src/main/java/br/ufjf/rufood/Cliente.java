package br.ufjf.rufood;

public class Cliente extends Usuario {

    private String cpf; 

    public Cliente(String nome, String email, String senha, String cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}