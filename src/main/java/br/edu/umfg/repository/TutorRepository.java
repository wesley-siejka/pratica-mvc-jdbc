package br.edu.umfg.repository;

import br.edu.umfg.model.Tutor;
import br.edu.umfg.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TutorRepository {

    public void salvar(Tutor tutor) throws SQLException {
        String sql = "INSERT INTO tutor (nome, endereco, telefone) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEndereco());
            stmt.setString(3, tutor.getTelefone());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tutor.setId(rs.getInt(1)); // Pega o ID gerado pelo Postgres e devolve pro Java
                }
            }
        }
    }

    public Tutor buscarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM tutor WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Tutor(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
                }
            }
        }
        return null;
    }

    public List<Tutor> listarTodos() throws SQLException {
        List<Tutor> lista = new ArrayList<>();
        String sql = "SELECT * FROM tutor";
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Tutor(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone")));
            }
        }
        return lista;
    }

    public void atualizar(Tutor tutor) throws SQLException {
        String sql = "UPDATE tutor SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEndereco());
            stmt.setString(3, tutor.getTelefone());
            stmt.setInt(4, tutor.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM tutor WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}