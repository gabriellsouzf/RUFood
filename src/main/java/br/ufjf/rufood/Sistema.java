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
    public boolean cpfCadastrado(String cpf) {

        for (int i = 0; i < usuarios.size(); i++) {

            Usuario usuario = usuarios.get(i);

            if (usuario instanceof Cliente) {

                Cliente cliente = (Cliente) usuario;

                if (cliente.getCpf().equals(cpf)) {
                    return true;
                }
            }

            if (usuario instanceof Motoboy) {

                Motoboy motoboy = (Motoboy) usuario;

                if (motoboy.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean cnpjCadastrado(String cnpj) {

        for (int i = 0; i < usuarios.size(); i++) {

            Usuario usuario = usuarios.get(i);

            if (usuario instanceof Restaurante) {

                Restaurante restaurante = (Restaurante) usuario;

                if (restaurante.getCnpj().equals(cnpj)) {
                    return true;
                }
            }
        }

        return false;
    }
}