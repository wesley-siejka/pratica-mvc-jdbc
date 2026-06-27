package br.edu.umfg.repository;

import br.edu.umfg.model.Veiculo;
import br.edu.umfg.util.Conexao;
import java.sql.*;

public class VeiculoRepository {
    public void salvar(Veiculo v) throws SQLException {
        String sql = "INSERT INTO veiculo (placa, modelo, ano, id_cliente) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, v.getPlaca());
            stmt.setString(2, v.getModelo());
            stmt.setInt(3, v.getAno());
            stmt.setInt(4, v.getIdCliente());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) v.setId(rs.getInt(1));
            }
        }
    }

    public Veiculo buscarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM veiculo WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return new Veiculo(rs.getInt("id"), rs.getString("placa"), rs.getString("modelo"), rs.getInt("ano"), rs.getInt("id_cliente"));
            }
        }
        return null;
    }
}