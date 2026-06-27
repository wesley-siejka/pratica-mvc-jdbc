package br.edu.umfg.service;

import br.edu.umfg.model.Animal;
import br.edu.umfg.repository.AnimalRepository;
import java.sql.SQLException;

public class AnimalService {
    private AnimalRepository repository = new AnimalRepository();

    public void salvar(Animal animal) throws SQLException {
        if (animal.getNome() == null || animal.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do animal é obrigatório.");
        }
        repository.salvar(animal);
    }
}