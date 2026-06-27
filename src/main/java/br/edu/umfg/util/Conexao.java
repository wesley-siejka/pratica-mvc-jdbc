package br.edu.umfg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/clinica_vet";
    private static final String USER = "postgres";

    private static final String PASS = "admin";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConexao();
            if (conn != null) {
                System.out.println(" Banco conectado!! ");
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Deu erro ao conectar! Veja o motivo: " + e.getMessage());
        }
    }
}