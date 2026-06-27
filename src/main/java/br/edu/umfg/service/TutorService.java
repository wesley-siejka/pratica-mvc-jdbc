package br.edu.umfg.service;

import br.edu.umfg.model.Tutor;
import br.edu.umfg.repository.TutorRepository;
import java.sql.SQLException;

public class TutorService {
    private TutorRepository repository = new TutorRepository();

    public void salvar(Tutor tutor) throws SQLException {
        // Validação simples: não permitir cadastro com nome vazio
        if (tutor.getNome() == null || tutor.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do tutor é obrigatório.");
        }
        repository.salvar(tutor);
    }
}