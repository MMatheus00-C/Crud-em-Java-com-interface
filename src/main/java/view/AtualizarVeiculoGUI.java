package view;

import dao.VeiculoDAO;
import model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AtualizarVeiculoGUI extends JFrame {
    private JTextField campoId, campoMarca, campoModelo, campoAno, campoCor, campoPlaca, campoQuilometragem, campoPrecoDiaria, campoCategoria, campoDescricao;
    private JCheckBox checkDisponivel;
    private JButton botaoBuscar, botaoAtualizar;
    private VeiculoDAO veiculoDAO;

    public AtualizarVeiculoGUI() {
        veiculoDAO = new VeiculoDAO();

        setTitle("Atualizar Veículo");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(12, 2));

        // Campos de entrada
        add(new JLabel("ID do Veículo:"));
        campoId = new JTextField();
        add(campoId);

        botaoBuscar = new JButton("Buscar");
        add(botaoBuscar);
        add(new JLabel()); // Placeholder

        add(new JLabel("Marca:"));
        campoMarca = new JTextField();
        add(campoMarca);

        add(new JLabel("Modelo:"));
        campoModelo = new JTextField();
        add(campoModelo);

        add(new JLabel("Ano:"));
        campoAno = new JTextField();
        add(campoAno);

        add(new JLabel("Cor:"));
        campoCor = new JTextField();
        add(campoCor);

        add(new JLabel("Placa:"));
        campoPlaca = new JTextField();
        add(campoPlaca);

        add(new JLabel("Quilometragem:"));
        campoQuilometragem = new JTextField();
        add(campoQuilometragem);

        add(new JLabel("Preço Diária:"));
        campoPrecoDiaria = new JTextField();
        add(campoPrecoDiaria);

        add(new JLabel("Disponível:"));
        checkDisponivel = new JCheckBox();
        add(checkDisponivel);

        add(new JLabel("Categoria:"));
        campoCategoria = new JTextField();
        add(campoCategoria);

        add(new JLabel("Descrição:"));
        campoDescricao = new JTextField();
        add(campoDescricao);

        botaoAtualizar = new JButton("Atualizar");
        add(botaoAtualizar);

        add(new JLabel("Locadora SJT"));

        // Ação do botão Buscar
        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(campoId.getText());
                    Veiculo veiculo = veiculoDAO.listarVeiculos().stream().filter(v -> v.getId() == id).findFirst().orElse(null);

                    if (veiculo != null) {
                        // Preenche os campos com os dados do veículo
                        campoMarca.setText(veiculo.getMarca());
                        campoModelo.setText(veiculo.getModelo());
                        campoAno.setText(String.valueOf(veiculo.getAno()));
                        campoCor.setText(veiculo.getCor());
                        campoPlaca.setText(veiculo.getPlaca());
                        campoQuilometragem.setText(String.valueOf(veiculo.getQuilometragem()));
                        campoPrecoDiaria.setText(String.valueOf(veiculo.getPrecoDiaria()));
                        checkDisponivel.setSelected(veiculo.isDisponivel());
                        campoCategoria.setText(veiculo.getCategoria());
                        campoDescricao.setText(veiculo.getDescricao());
                    } else {
                        JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Atualizar
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(campoId.getText());
                    Veiculo veiculo = new Veiculo(
                            id,
                            campoMarca.getText(),
                            campoModelo.getText(),
                            Integer.parseInt(campoAno.getText()),
                            campoCor.getText(),
                            campoPlaca.getText(),
                            Integer.parseInt(campoQuilometragem.getText()),
                            Double.parseDouble(campoPrecoDiaria.getText()),
                            checkDisponivel.isSelected(),
                            campoCategoria.getText(),
                            campoDescricao.getText()
                    );
                    veiculoDAO.atualizarVeiculo(veiculo);
                    JOptionPane.showMessageDialog(null, "Veículo atualizado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar veículo: " + ex.getMessage());
                }
            }
        });
    }
}
