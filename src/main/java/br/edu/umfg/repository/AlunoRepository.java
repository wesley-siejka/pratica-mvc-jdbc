package br.edu.umfg.repository;

import br.edu.umfg.model.Aluno;
import br.edu.umfg.util.Conexao;
import java.sql.*;

public class AlunoRepository {
    public void salvar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) aluno.setId(rs.getInt(1));
            }
        }
    }
}