package br.edu.umfg.controller;

import br.edu.umfg.model.Consulta;
import br.edu.umfg.service.ConsultaService;
import java.sql.SQLException;
import java.time.LocalDate;

public class ConsultaController {
    private ConsultaService service = new ConsultaService();

    public void registrar(Integer idAnimal, LocalDate data, String motivo, Double valor) throws SQLException {
        Consulta consulta = new Consulta(null, idAnimal, data, motivo, valor);
        service.registrar(consulta);
    }
}