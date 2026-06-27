package br.edu.umfg.repository;

import br.edu.umfg.model.OrdemServico;
import br.edu.umfg.util.Conexao;
import java.sql.*;

public class OrdemServicoRepository {
    public void salvar(OrdemServico os) throws SQLException {
        String sql = "INSERT INTO ordem_servico (id_veiculo, descricao, valor, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, os.getIdVeiculo());
            stmt.setString(2, os.getDescricao());
            stmt.setDouble(3, os.getValor());
            stmt.setString(4, os.getStatus());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) os.setId(rs.getInt(1));
            }
        }
    }
}