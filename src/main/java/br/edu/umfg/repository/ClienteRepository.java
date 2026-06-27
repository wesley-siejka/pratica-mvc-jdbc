package br.edu.umfg.repository;

import br.edu.umfg.model.Cliente;
import br.edu.umfg.util.Conexao;
import java.sql.*;

public class ClienteRepository {
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) cliente.setId(rs.getInt(1));
            }
        }
    }
}