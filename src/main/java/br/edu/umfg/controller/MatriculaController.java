package br.edu.umfg.controller;

import br.edu.umfg.model.Matricula;
import br.edu.umfg.service.MatriculaService;
import java.sql.SQLException;
import java.time.LocalDate;

public class MatriculaController {
    private MatriculaService service = new MatriculaService();

    public void matricular(Integer idAluno, Integer idDisciplina) throws SQLException {
        service.matricular(new Matricula(null, idAluno, idDisciplina, LocalDate.now()));
    }
}