package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import dao.VeiculoDAO;

public class MenuGUI extends JFrame {
    private JButton btnAdicionar, btnListar, btnAtualizar, btnExcluir;

    public MenuGUI() {
        setTitle("Menu - Locadora de Veículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        btnAdicionar = new JButton("Adicionar Veículo");
        btnListar = new JButton("Listar Veículos");
        btnAtualizar = new JButton("Atualizar Veículo");
        btnExcluir = new JButton("Excluir Veículo");

        btnAdicionar.addActionListener((ActionEvent e) -> new AdicionarVeiculoGUI());
        btnListar.addActionListener((ActionEvent e) -> new ListarVeiculosGUI());
        btnAtualizar.addActionListener(e -> {
            new AtualizarVeiculoGUI().setVisible(true);
        });

        btnExcluir.addActionListener(e -> {
            new ExcluirVeiculoGUI().setVisible(true);
        });


        add(btnAdicionar);
        add(btnListar);
        add(btnAtualizar);
        add(btnExcluir);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
