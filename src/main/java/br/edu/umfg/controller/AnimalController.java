package br.edu.umfg.controller;

import br.edu.umfg.model.Animal;
import br.edu.umfg.service.AnimalService;
import java.sql.SQLException;

public class AnimalController {
    private AnimalService service = new AnimalService();

    public void salvar(String nome, String especie, String raca, Integer idTutor) throws SQLException {
        Animal animal = new Animal(null, nome, especie, raca, idTutor);
        service.salvar(animal);
    }
}