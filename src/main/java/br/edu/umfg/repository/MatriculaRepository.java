package br.edu.umfg.repository;

import br.edu.umfg.model.Matricula;
import br.edu.umfg.util.Conexao;
import java.sql.*;

public class MatriculaRepository {
    public void salvar(Matricula m) throws SQLException {
        String sql = "INSERT INTO matricula (id_aluno, id_disciplina, data_matricula) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, m.getIdAluno());
            stmt.setInt(2, m.getIdDisciplina());
            stmt.setDate(3, Date.valueOf(m.getDataMatricula()));
            stmt.executeUpdate();
        }
    }
}