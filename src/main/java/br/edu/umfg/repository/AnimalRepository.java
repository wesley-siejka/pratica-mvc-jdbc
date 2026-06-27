package br.edu.umfg.repository;

import br.edu.umfg.model.Animal;
import br.edu.umfg.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    public void salvar(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (nome, especie, raca, id_tutor) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdTutor());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    animal.setId(rs.getInt(1));
                }
            }
        }
    }

    public Animal buscarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM animal WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("especie"), rs.getString("raca"), rs.getInt("id_tutor"));
                }
            }
        }
        return null;
    }

    // EXIGÊNCIA ESPECÍFICA DO CLIENTE: "ver todos os animais que o tutor tem no sistema"
    public List<Animal> listarPorTutor(Integer idTutor) throws SQLException {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animal WHERE id_tutor = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTutor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("especie"), rs.getString("raca"), rs.getInt("id_tutor")));
                }
            }
        }
        return lista;
    }

    public void atualizar(Animal animal) throws SQLException {
        String sql = "UPDATE animal SET nome = ?, especie = ?, raca = ?, id_tutor = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdTutor());
            stmt.setInt(5, animal.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM animal WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}