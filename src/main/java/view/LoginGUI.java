package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    public LoginGUI() {
        setTitle("Login - Locadora de Veículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuário:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        btnLogin = new JButton("Entrar");
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if ("Duduchi".equals(usuario) && "nota100".equals(senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    dispose();
                    new MenuGUI(); // Abre o menu após login bem-sucedido
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                }
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
