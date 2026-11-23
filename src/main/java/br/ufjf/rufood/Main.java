package br.ufjf.rufood;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {

        JFrame janela = new JFrame();

        janela.setTitle("RUFood");
        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Bem-vindo ao RUFood!");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton botaoCliente = new JButton("Cliente");
        JButton botaoRestaurante = new JButton("Restaurante");
        JButton botaoMotoboy = new JButton("Motoboy");

        JPanel painel = new JPanel();

        painel.add(botaoCliente);
        painel.add(botaoRestaurante);
        painel.add(botaoMotoboy);

        janela.add(titulo, "North");
        janela.add(painel, "Center");

        janela.setVisible(true);

        // BOTÃO CLIENTE
        botaoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 cadastrarCliente();
            }
        });

        // BOTÃO RESTAURANTE
        botaoRestaurante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarRestaurante();
            }
        });

        // BOTÃO MOTOBOY
        botaoMotoboy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarMotoboy();
            }
        });
    }
    // Método para cadastrar cliente
    private static void cadastrarCliente() {

    String nome = JOptionPane.showInputDialog("Digite seu nome:");

    if (!validarNome(nome)) {
    JOptionPane.showMessageDialog(null, "Nome inválido!");
    return;
}
    nome = nome.trim();

    String email = JOptionPane.showInputDialog("Digite seu e-mail:");

    if (!validarEmail(email)) {
        JOptionPane.showMessageDialog(null, "E-mail inválido!");
        return;
    }

    String senha = JOptionPane.showInputDialog("Digite sua senha:");

    if (senha == null || senha.isEmpty()) {
        return;
    }

    Cliente cliente = new Cliente(nome, email, senha);

    JOptionPane.showMessageDialog(null,
            "Cliente cadastrado com sucesso!\n\n" +
            "Nome: " + cliente.getNome() +
            "\nE-mail: " + cliente.getEmail());
}
private static void cadastrarRestaurante() {

    String nome = JOptionPane.showInputDialog("Digite o nome do restaurante:");

    if (!validarNome(nome)) {
    JOptionPane.showMessageDialog(null, "Nome inválido!");
    return;
}

    nome = nome.trim();

    String email = JOptionPane.showInputDialog("Digite o e-mail:");

    if (!validarEmail(email)) {
        JOptionPane.showMessageDialog(null, "E-mail inválido!");
        return;
    }

    String senha = JOptionPane.showInputDialog("Digite a senha:");

    if (senha == null || senha.isEmpty()) {
        return;
    }

    Restaurante restaurante = new Restaurante(nome, email, senha);

    JOptionPane.showMessageDialog(null,
            "Restaurante cadastrado com sucesso!\n\n" +
            "Nome: " + restaurante.getNome() +
            "\nE-mail: " + restaurante.getEmail());
}

//Método para cadastrar motoboy
private static void cadastrarMotoboy() {

    String nome = JOptionPane.showInputDialog("Digite seu nome:");

    if (!validarNome(nome)) {
    JOptionPane.showMessageDialog(null, "Nome inválido!");
    return;
}
    nome = nome.trim();

    String email = JOptionPane.showInputDialog("Digite seu e-mail:");

    if (!validarEmail(email)) {
        JOptionPane.showMessageDialog(null, "E-mail inválido!");
        return;
    }

    String senha = JOptionPane.showInputDialog("Digite sua senha:");

    if (senha == null || senha.isEmpty()) {
        return;
    }

    Motoboy motoboy = new Motoboy(nome, email, senha);

    JOptionPane.showMessageDialog(null,
            "Motoboy cadastrado com sucesso!\n\n" +
            "Nome: " + motoboy.getNome() +
            "\nE-mail: " + motoboy.getEmail());
}

//Valida nome
private static boolean validarNome(String nome) {
    return nome != null && nome.trim().length() >= 2;
}

//Valida e-mail
private static boolean validarEmail(String email) {
    return email != null && email.contains("@") && email.contains(".");
}
}

