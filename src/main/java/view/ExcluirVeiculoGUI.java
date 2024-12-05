package view;

import dao.VeiculoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ExcluirVeiculoGUI extends JFrame {
    private JTextField campoId;
    private JButton botaoExcluir;
    private VeiculoDAO veiculoDAO;

    public ExcluirVeiculoGUI() {
        veiculoDAO = new VeiculoDAO();

        setTitle("Excluir Veículo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("ID do Veículo:"));
        campoId = new JTextField();
        add(campoId);

        botaoExcluir = new JButton("Excluir");
        add(botaoExcluir);

        add(new JLabel()); // Placeholder

        // Ação do botão Excluir
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(campoId.getText());
                    veiculoDAO.excluirVeiculo(id);
                    JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir veículo: " + ex.getMessage());
                }
            }
        });
    }
}
