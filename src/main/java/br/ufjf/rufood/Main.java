
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

    private static Sistema sistema = new Sistema();

    // =====================================
    // INTERFACE GRAFICA
    // =====================================

    public static void main(String[] args) {

        // Criacao da janela
        JFrame janela = new JFrame();

        janela.setTitle("RUFood");
        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        // Criacao do titulo
        JLabel titulo = new JLabel("Bem-vindo ao RUFood!");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Criacao dos botoes
        JButton botaoCliente = new JButton("Cliente");
        JButton botaoRestaurante = new JButton("Restaurante");
        JButton botaoMotoboy = new JButton("Motoboy");

        // Criacao do painel
        JPanel painel = new JPanel();

        painel.add(botaoCliente);
        painel.add(botaoRestaurante);
        painel.add(botaoMotoboy);

        janela.add(titulo, "North");
        janela.add(painel, "Center");

        // Evento do botao Cliente
        botaoCliente.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        // Evento do botao Restaurante
        botaoRestaurante.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cadastrarRestaurante();
            }
        });

        // Evento do botao Motoboy
        botaoMotoboy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cadastrarMotoboy();
            }
        });

        // Exibe a janela
        janela.setVisible(true);
    }

    // =====================================
    // CADASTRO DE CLIENTE
    // =====================================

    private static void cadastrarCliente() {

        String nome = JOptionPane.showInputDialog("Digite seu nome:");

        if (validarNome(nome) == false) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        nome = nome.trim();

        String email = JOptionPane.showInputDialog("Digite seu e-mail:");

        if (validarEmail(email) == false) {
            JOptionPane.showMessageDialog(null, "E-mail inválido!");
            return;
        }

        String cpf = JOptionPane.showInputDialog("Digite seu CPF:");

        if (validarCpf(cpf) == false) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return;
        }

        String senha = JOptionPane.showInputDialog("Digite sua senha:");

        if (senha == null) {
            return;
        }

        if (senha.length() == 0) {
            return;
        }

        // Cria o objeto Cliente
        Cliente cliente = new Cliente(nome, email, senha, cpf);

        // Armazena o cliente no sistema
        sistema.cadastrarUsuario(cliente);

        // Exibe os dados do cadastro
        JOptionPane.showMessageDialog(null,
                "Cliente cadastrado com sucesso!\n\n" +
                "Nome: " + cliente.getNome() +
                "\nE-mail: " + cliente.getEmail() +
                "\nCPF: " + cliente.getCpf());
    }

    // =====================================
    // CADASTRO DE RESTAURANTE
    // =====================================

    private static void cadastrarRestaurante() {

        String nome = JOptionPane.showInputDialog("Digite o nome do restaurante:");

        if (validarNome(nome) == false) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        nome = nome.trim();

        String email = JOptionPane.showInputDialog("Digite o e-mail:");

        if (validarEmail(email) == false) {
            JOptionPane.showMessageDialog(null, "E-mail inválido!");
            return;
        }

        String cnpj = JOptionPane.showInputDialog("Digite o CNPJ:");

        if (validarCnpj(cnpj) == false) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!");
            return;
        }

        String senha = JOptionPane.showInputDialog("Digite a senha:");

        if (senha == null) {
            return;
        }

        if (senha.length() == 0) {
            return;
        }

        // Cria o objeto Restaurante
        Restaurante restaurante = new Restaurante(nome, email, senha, cnpj);

        // Armazena o restaurante no sistema
        sistema.cadastrarUsuario(restaurante);

        // Exibe os dados do cadastro
        JOptionPane.showMessageDialog(null,
                "Restaurante cadastrado com sucesso!\n\n" +
                "Nome: " + restaurante.getNome() +
                "\nE-mail: " + restaurante.getEmail() +
                "\nCNPJ: " + restaurante.getCnpj());
    }

    // =====================================
    // CADASTRO DE MOTOBOY
    // =====================================

    private static void cadastrarMotoboy() {

        String nome = JOptionPane.showInputDialog("Digite seu nome:");

        if (validarNome(nome) == false) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        nome = nome.trim();

        String email = JOptionPane.showInputDialog("Digite seu e-mail:");

        if (validarEmail(email) == false) {
            JOptionPane.showMessageDialog(null, "E-mail inválido!");
            return;
        }

        String cpf = JOptionPane.showInputDialog("Digite seu CPF:");

        if (validarCpf(cpf) == false) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return;
        }

        String senha = JOptionPane.showInputDialog("Digite sua senha:");

        if (senha == null) {
            return;
        }

        if (senha.length() == 0) {
            return;
        }

        // Cria o objeto Motoboy
        Motoboy motoboy = new Motoboy(nome, email, senha, cpf);

        // Armazena o motoboy no sistema
        sistema.cadastrarUsuario(motoboy);

        // Exibe os dados do cadastro
        JOptionPane.showMessageDialog(null,
                "Motoboy cadastrado com sucesso!\n\n" +
                "Nome: " + motoboy.getNome() +
                "\nE-mail: " + motoboy.getEmail() +
                "\nCPF: " + motoboy.getCpf());
    }

    // =====================================
    // VALIDACAO DE NOME
    // =====================================

    private static boolean validarNome(String nome) {

        // Verifica se o usuario cancelou
        if (nome == null) {
            return false;
        }

        // Remove espacos do inicio e do final
        nome = nome.trim();

        // Verifica a quantidade de caracteres
        if (nome.length() < 2) {
            return false;
        }

        return true;
    }

    // =====================================
    // VALIDACAO DE E-MAIL
    // =====================================

    private static boolean validarEmail(String email) {

        // Verifica se o usuario cancelou
        if (email == null) {
            return false;
        }

        // Verifica se possui arroba
        if (email.contains("@") == false) {
            return false;
        }

        // Verifica se possui ponto
        if (email.contains(".") == false) {
            return false;
        }

        return true;
    }

    // =====================================
    // VALIDACAO DE CPF
    // =====================================

    private static boolean validarCpf(String cpf) {

        if (cpf == null) {
            return false;
        }

        // Remove pontos e tracos
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        // Verifica se possui 11 caracteres
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os caracteres sao numeros
        for (int i = 0; i < 11; i++) {

            char numero = cpf.charAt(i);

            if (numero < '0') {
                return false;
            }

            if (numero > '9') {
                return false;
            }
        }

        // Verifica se todos os numeros sao iguais
        boolean todosIguais = true;

        for (int i = 1; i < 11; i++) {

            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosIguais = false;
            }
        }

        if (todosIguais == true) {
            return false;
        }

        // Calcula o primeiro digito verificador
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

        // Compara com o primeiro digito do CPF
        int digitoCpf = cpf.charAt(9) - '0';

        if (primeiroDigito != digitoCpf) {
            return false;
        }

        // Calcula o segundo digito verificador
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

        // Compara com o segundo digito do CPF
        digitoCpf = cpf.charAt(10) - '0';

        if (segundoDigito != digitoCpf) {
            return false;
        }

        return true;
    }

    // =====================================
    // VALIDACAO DE CNPJ
    // =====================================

    private static boolean validarCnpj(String cnpj) {

        if (cnpj == null) {
            return false;
        }

        // Remove pontos, tracos e barras
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");

        // Verifica se possui 14 caracteres
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os caracteres sao numeros
        for (int i = 0; i < 14; i++) {

            char numero = cnpj.charAt(i);

            if (numero < '0') {
                return false;
            }

            if (numero > '9') {
                return false;
            }
        }

        // Verifica se todos os numeros sao iguais
        boolean todosIguais = true;

        for (int i = 1; i < 14; i++) {

            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                todosIguais = false;
            }
        }

        if (todosIguais == true) {
            return false;
        }

        // Pesos utilizados no primeiro digito
        int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        // Calcula o primeiro digito verificador
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

        // Compara com o primeiro digito do CNPJ
        int digitoCnpj = cnpj.charAt(12) - '0';

        if (primeiroDigito != digitoCnpj) {
            return false;
        }

        // Pesos utilizados no segundo digito
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        // Calcula o segundo digito verificador
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

        // Compara com o segundo digito do CNPJ
        digitoCnpj = cnpj.charAt(13) - '0';

        if (segundoDigito != digitoCnpj) {
            return false;
        }

        return true;
    }
}

