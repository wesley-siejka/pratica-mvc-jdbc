package br.edu.umfg.service;

import br.edu.umfg.model.Disciplina;
import br.edu.umfg.repository.DisciplinaRepository;
import java.sql.SQLException;

public class DisciplinaService {
    private DisciplinaRepository repo = new DisciplinaRepository();

    public void salvar(Disciplina disciplina) throws SQLException {
        // Regra de negócio: carga horária não pode ser negativa
        if (disciplina.getCargaHoraria() < 0) {
            throw new IllegalArgumentException("Carga horária não pode ser negativa!");
        }
        repo.salvar(disciplina);
    }
}