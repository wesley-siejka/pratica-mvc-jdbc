package br.edu.umfg.repository;

import br.edu.umfg.model.Disciplina;
import br.edu.umfg.util.Conexao;
import java.sql.*;

public class DisciplinaRepository {
    public void salvar(Disciplina d) throws SQLException {
        String sql = "INSERT INTO disciplina (nome, carga_horaria) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, d.getNome());
            stmt.setInt(2, 40); // Exemplo de carga horária padrão
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) d.setId(rs.getInt(1));
            }
        }
    }
}