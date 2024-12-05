package view;

import dao.VeiculoDAO;
import model.Veiculo;

import javax.swing.*;
import java.awt.*;

public class AdicionarVeiculoGUI extends JFrame {
    private JTextField txtMarca, txtModelo, txtAno, txtCor, txtPlaca, txtQuilometragem, txtPrecoDiaria, txtCategoria, txtDescricao;
    private JCheckBox chkDisponivel;
    private JButton btnSalvar;

    public AdicionarVeiculoGUI() {
        setTitle("Adicionar Veículo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        add(txtMarca);

        add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        add(txtModelo);

        add(new JLabel("Ano:"));
        txtAno = new JTextField();
        add(txtAno);

        add(new JLabel("Cor:"));
        txtCor = new JTextField();
        add(txtCor);

        add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        add(txtPlaca);

        add(new JLabel("Quilometragem:"));
        txtQuilometragem = new JTextField();
        add(txtQuilometragem);

        add(new JLabel("Preço Diária:"));
        txtPrecoDiaria = new JTextField();
        add(txtPrecoDiaria);

        add(new JLabel("Disponível:"));
        chkDisponivel = new JCheckBox();
        add(chkDisponivel);

        add(new JLabel("Categoria:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        add(txtDescricao);

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                Veiculo veiculo = new Veiculo(
                        txtMarca.getText(),
                        txtModelo.getText(),
                        Integer.parseInt(txtAno.getText()),
                        txtCor.getText(),
                        txtPlaca.getText(),
                        Integer.parseInt(txtQuilometragem.getText()),
                        Double.parseDouble(txtPrecoDiaria.getText()),
                        chkDisponivel.isSelected(),
                        txtCategoria.getText(),
                        txtDescricao.getText()
                );

                VeiculoDAO veiculoDAO = new VeiculoDAO();
                veiculoDAO.adicionarVeiculo(veiculo);

                JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar veículo: " + ex.getMessage());
            }
        });

        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
