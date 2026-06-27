package br.edu.umfg.controller;

import br.edu.umfg.model.Tutor;
import br.edu.umfg.service.TutorService;
import java.sql.SQLException;

public class TutorController {
    private TutorService service = new TutorService();

    public void salvar(String nome, String endereco, String telefone) throws SQLException {
        Tutor tutor = new Tutor(null, nome, endereco, telefone);
        service.salvar(tutor);
    }
}