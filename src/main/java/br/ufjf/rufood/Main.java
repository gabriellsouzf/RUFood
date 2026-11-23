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

    String cpf = JOptionPane.showInputDialog("Digite seu CPF:");

    if (!validarCpf(cpf)) {
        JOptionPane.showMessageDialog(null, "CPF inválido!");
        return;
    }

    String senha = JOptionPane.showInputDialog("Digite sua senha:");

    if (senha == null || senha.isEmpty()) {
        return;
    }

    Cliente cliente = new Cliente(nome, email, senha, cpf);

    JOptionPane.showMessageDialog(null,
            "Cliente cadastrado com sucesso!\n\n" +
            "Nome: " + cliente.getNome() +
            "\nE-mail: " + cliente.getEmail() +
            "\nCPF: " + cliente.getCpf());
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

    String cnpj = JOptionPane.showInputDialog("Digite o CNPJ:");

    if (!validarCnpj(cnpj)) {
        JOptionPane.showMessageDialog(null, "CNPJ inválido!");
        return;
    }

    String senha = JOptionPane.showInputDialog("Digite a senha:");

    if (senha == null || senha.isEmpty()) {
        return;
    }

    Restaurante restaurante = new Restaurante(nome, email, senha, cnpj);

    JOptionPane.showMessageDialog(null,
            "Restaurante cadastrado com sucesso!\n\n" +
            "Nome: " + restaurante.getNome() +
            "\nE-mail: " + restaurante.getEmail() +
            "\nCNPJ: " + restaurante.getCnpj());
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

    String cpf = JOptionPane.showInputDialog("Digite seu CPF:");

    if (!validarCpf(cpf)) {
        JOptionPane.showMessageDialog(null, "CPF inválido!");
        return;
    }

    String senha = JOptionPane.showInputDialog("Digite sua senha:");

    if (senha == null || senha.isEmpty()) {
        return;
    }

    Motoboy motoboy = new Motoboy(nome, email, senha, cpf);

    JOptionPane.showMessageDialog(null,
            "Motoboy cadastrado com sucesso!\n\n" +
            "Nome: " + motoboy.getNome() +
            "\nE-mail: " + motoboy.getEmail() +
            "\nCPF: " + motoboy.getCpf());
}

//Valida nome
private static boolean validarNome(String nome) {
    return nome != null && nome.trim().length() >= 2;
}

//Valida e-mail
private static boolean validarEmail(String email) {
    return email != null && email.contains("@") && email.contains(".");
}

private static boolean validarCpf(String cpf) {

    if (cpf == null) {
        return false;
    }

    // Remove pontos e traços
    cpf = cpf.replace(".", "");
    cpf = cpf.replace("-", "");

    // Verifica se possui 11 dígitos
    if (cpf.length() != 11) {
        return false;
    }

    for (int i = 0; i < 11; i++) {

        char numero = cpf.charAt(i);

        if (numero < '0' || numero > '9') {
            return false;
        }
    }

    boolean todosIguais = true;

    for (int i = 1; i < 11; i++) {

        if (cpf.charAt(i) != cpf.charAt(0)) {
            todosIguais = false;
        }
    }

    if (todosIguais == true) {
        return false;
    }

    int soma = 0;

    for (int i = 0; i < 9; i++) {

        int numero = cpf.charAt(i) - '0';

        soma = soma + numero * (10 - i);
    }

    int resto = soma % 11;
    int primeiroDigito;

    if (resto < 2) {
        primeiroDigito = 0;
    } else {
        primeiroDigito = 11 - resto;
    }

    int digitoCpf = cpf.charAt(9) - '0';

    if (primeiroDigito != digitoCpf) {
        return false;
    }

    soma = 0;

    for (int i = 0; i < 10; i++) {

        int numero = cpf.charAt(i) - '0';

        soma = soma + numero * (11 - i);
    }

    resto = soma % 11;
    int segundoDigito;

    if (resto < 2) {
        segundoDigito = 0;
    } else {
        segundoDigito = 11 - resto;
    }

    digitoCpf = cpf.charAt(10) - '0';

    if (segundoDigito != digitoCpf) {
        return false;
    }

    return true;
}

//Valida CNPJ
private static boolean validarCnpj(String cnpj) {

    if (cnpj == null) {
        return false;
    }

    cnpj = cnpj.replace(".", "");
    cnpj = cnpj.replace("-", "");
    cnpj = cnpj.replace("/", "");

    if (cnpj.length() != 14) {
        return false;
    }

    for (int i = 0; i < 14; i++) {

        char numero = cnpj.charAt(i);

        if (numero < '0' || numero > '9') {
            return false;
        }
    }

    boolean todosIguais = true;

    for (int i = 1; i < 14; i++) {

        if (cnpj.charAt(i) != cnpj.charAt(0)) {
            todosIguais = false;
        }
    }

    if (todosIguais == true) {
        return false;
    }

    int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    int soma = 0;

    for (int i = 0; i < 12; i++) {

        int numero = cnpj.charAt(i) - '0';

        soma = soma + numero * pesos[i];
    }

    int resto = soma % 11;
    int primeiroDigito;

    if (resto < 2) {
        primeiroDigito = 0;
    } else {
        primeiroDigito = 11 - resto;
    }

    int digitoCnpj = cnpj.charAt(12) - '0';

    if (primeiroDigito != digitoCnpj) {
        return false;
    }

    int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    soma = 0;

    for (int i = 0; i < 13; i++) {

        int numero = cnpj.charAt(i) - '0';

        soma = soma + numero * pesos2[i];
    }

    resto = soma % 11;
    int segundoDigito;

    if (resto < 2) {
        segundoDigito = 0;
    } else {
        segundoDigito = 11 - resto;
    }

    digitoCnpj = cnpj.charAt(13) - '0';

    if (segundoDigito != digitoCnpj) {
        return false;
    }

    return true;
}
}

