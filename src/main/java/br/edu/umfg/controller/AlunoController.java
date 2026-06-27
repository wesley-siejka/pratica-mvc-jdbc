package br.edu.umfg.controller;

import br.edu.umfg.model.Aluno;
import br.edu.umfg.service.AlunoService;
import java.sql.SQLException;

public class AlunoController {
    private AlunoService service = new AlunoService();

    public void salvar(String nome, String email) throws SQLException {
        service.salvar(new Aluno(null, nome, email));
    }
}