package br.edu.umfg.service;

import br.edu.umfg.model.Consulta;
import br.edu.umfg.repository.AnimalRepository;
import br.edu.umfg.repository.ConsultaRepository;
import java.sql.SQLException;

public class ConsultaService {
    private ConsultaRepository consultaRepo = new ConsultaRepository();
    private AnimalRepository animalRepo = new AnimalRepository();

    public void registrar(Consulta consulta) throws SQLException {
        // Regra: Valor não pode ser negativo
        if (consulta.getValor() < 0) {
            throw new IllegalArgumentException("O valor da consulta não pode ser negativo.");
        }

        // Regra: Não permitir registrar consulta para animal que não existe
        if (animalRepo.buscarPorId(consulta.getIdAnimal()) == null) {
            throw new IllegalArgumentException("Erro: Animal não encontrado no cadastro.");
        }

        consultaRepo.salvar(consulta);
    }
}