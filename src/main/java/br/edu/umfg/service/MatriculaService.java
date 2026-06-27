package br.edu.umfg.service;

import br.edu.umfg.model.Matricula;
import br.edu.umfg.repository.*;
import java.sql.SQLException;

public class MatriculaService {
    private MatriculaRepository matRepo = new MatriculaRepository();

    public void matricular(Matricula m) throws SQLException {
        // Regra de exemplo: data não pode ser nula
        if (m.getDataMatricula() == null) throw new IllegalArgumentException("Data inválida!");
        matRepo.salvar(m);
    }
}