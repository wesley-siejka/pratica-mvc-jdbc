package br.edu.umfg.repository;

import br.edu.umfg.model.Consulta;
import br.edu.umfg.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {

    public void salvar(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta (id_animal, data_consulta, motivo, valor) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, consulta.getIdAnimal());
            stmt.setDate(2, Date.valueOf(consulta.getDataConsulta())); // Converte LocalDate para java.sql.Date
            stmt.setString(3, consulta.getMotivo());
            stmt.setDouble(4, consulta.getValor());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    consulta.setId(rs.getInt(1));
                }
            }
        }
    }

    public Consulta buscarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM consulta WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Consulta(
                            rs.getInt("id"),
                            rs.getInt("id_animal"),
                            rs.getDate("data_consulta").toLocalDate(),
                            rs.getString("motivo"),
                            rs.getDouble("valor")
                    );
                }
            }
        }
        return null;
    }

    // EXIGÊNCIA ESPECÍFICA DO CLIENTE: "consultar todas as consultas de um animal específico"
    public List<Consulta> listarPorAnimal(Integer idAnimal) throws SQLException {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta WHERE id_animal = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAnimal);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Consulta(
                            rs.getInt("id"),
                            rs.getInt("id_animal"),
                            rs.getDate("data_consulta").toLocalDate(),
                            rs.getString("motivo"),
                            rs.getDouble("valor")
                    ));
                }
            }
        }
        return lista;
    }

    public void atualizar(Consulta consulta) throws SQLException {
        String sql = "UPDATE consulta SET id_animal = ?, data_consulta = ?, motivo = ?, valor = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getIdAnimal());
            stmt.setDate(2, Date.valueOf(consulta.getDataConsulta()));
            stmt.setString(3, consulta.getMotivo());
            stmt.setDouble(4, consulta.getValor());
            stmt.setInt(5, consulta.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}