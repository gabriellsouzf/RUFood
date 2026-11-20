package br.ufjf.rufood;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {

    public static void main(String[] args) {

        JFrame janela = new JFrame();

        janela.setTitle("RUFood");
        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Bem-vindo ao RUFood!");

        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        janela.add(titulo);

        janela.setVisible(true);

    }
}