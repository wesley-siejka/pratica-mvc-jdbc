package br.edu.umfg.service;

import br.edu.umfg.model.Aluno;
import br.edu.umfg.repository.AlunoRepository;
import java.sql.SQLException;

public class AlunoService {
    private AlunoRepository repo = new AlunoRepository();

    public void salvar(Aluno aluno) throws SQLException {
        // Regra de negócio: email não pode ser vazio
        if (aluno.getEmail() == null || aluno.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do aluno é obrigatório!");
        }
        repo.salvar(aluno);
    }
}