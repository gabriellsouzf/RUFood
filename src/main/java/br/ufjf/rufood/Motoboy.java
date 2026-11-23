package br.ufjf.rufood;

public class Motoboy extends Usuario {

    private String cpf;

    public Motoboy(String nome, String email, String senha, String cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}