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

    public boolean emailCadastrado(String email) {

        for (int i = 0; i < usuarios.size(); i++) {

            Usuario usuario = usuarios.get(i);

            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }
}