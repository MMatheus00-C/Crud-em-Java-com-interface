package dao;

import model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    public void adicionarVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO veiculos (marca, modelo, ano, cor, placa, quilometragem, preco_diaria, disponivel, categoria, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getPlaca());
            stmt.setInt(6, veiculo.getQuilometragem());
            stmt.setDouble(7, veiculo.getPrecoDiaria());
            stmt.setBoolean(8, veiculo.isDisponivel());
            stmt.setString(9, veiculo.getCategoria());
            stmt.setString(10, veiculo.getDescricao());
            stmt.executeUpdate();
        }
    }

    public List<Veiculo> listarVeiculos() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                veiculos.add(new Veiculo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("cor"),
                        rs.getString("placa"),
                        rs.getInt("quilometragem"),
                        rs.getDouble("preco_diaria"),
                        rs.getBoolean("disponivel"),
                        rs.getString("categoria"),
                        rs.getString("descricao")
                ));
            }
        }
        return veiculos;
    }

    public void atualizarVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE veiculos SET marca = ?, modelo = ?, ano = ?, cor = ?, placa = ?, quilometragem = ?, preco_diaria = ?, disponivel = ?, categoria = ?, descricao = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getPlaca());
            stmt.setInt(6, veiculo.getQuilometragem());
            stmt.setDouble(7, veiculo.getPrecoDiaria());
            stmt.setBoolean(8, veiculo.isDisponivel());
            stmt.setString(9, veiculo.getCategoria());
            stmt.setString(10, veiculo.getDescricao());
            stmt.setInt(11, veiculo.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Erro: Nenhum veículo com o ID especificado encontrado.");
            }
        }
    }


    public void excluirVeiculo(int id) throws SQLException {
        String sql = "DELETE FROM veiculos WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("Erro: Nenhum veículo com o ID especificado encontrado.");
            }
        }
    }
}
