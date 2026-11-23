package br.ufjf.rufood;

public class Restaurante extends Usuario {

    private String cnpj;

    public Restaurante(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
    }
    public String getCnpj() {
        return cnpj;
    }
}