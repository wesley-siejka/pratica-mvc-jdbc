package br.edu.umfg.controller;

import br.edu.umfg.model.Disciplina;
import br.edu.umfg.service.DisciplinaService;
import java.sql.SQLException;

public class DisciplinaController {
    private DisciplinaService service = new DisciplinaService();

    public void salvar(String nome, Integer cargaHoraria) throws SQLException {
        service.salvar(new Disciplina(null, nome, cargaHoraria));
    }
}