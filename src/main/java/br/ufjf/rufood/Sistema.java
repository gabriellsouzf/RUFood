package br.ufjf.rufood;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Usuario> usuarios;

    public Sistema() {
        usuarios = new ArrayList<Usuario>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}