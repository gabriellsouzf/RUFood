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
                JOptionPane.showMessageDialog(janela, "Você selecionou Restaurante!");
            }
        });

        // BOTÃO MOTOBOY
        botaoMotoboy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(janela, "Você selecionou Motoboy!");
            }
        });
    }
    // Método para cadastrar cliente
    private static void cadastrarCliente() {

    String nome = JOptionPane.showInputDialog("Digite seu nome:");

    if (nome == null || nome.isEmpty()) {
        return;
    }

    String email = JOptionPane.showInputDialog("Digite seu e-mail:");

    if (email == null || email.isEmpty()) {
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
}
