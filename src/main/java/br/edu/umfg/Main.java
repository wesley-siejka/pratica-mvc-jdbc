package br.edu.umfg;

import br.edu.umfg.controller.AnimalController;
import br.edu.umfg.controller.ConsultaController;
import br.edu.umfg.controller.TutorController;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TutorController tutorController = new TutorController();
        AnimalController animalController = new AnimalController();
        ConsultaController consultaController = new ConsultaController();

        try {
            System.out.println("--- INICIANDO FLUXO: CLINICA VETERINARIA ---");

            // 1. Cadastrando Tutor (ID gerado automaticamente pelo banco)
            tutorController.salvar("João Silva", "Rua A, 123", "9999-8888");
            System.out.println("Tutor cadastrado com sucesso.");

            // 2. Cadastrando Animal vinculado ao Tutor (ID 1)
            animalController.salvar("Rex", "Cachorro", "Labrador", 1);
            System.out.println("Animal cadastrado vinculado ao Tutor ID 1.");

            // 3. Registrando Consulta
            consultaController.registrar(1, LocalDate.now(), "Check-up anual", 150.0);
            System.out.println("Consulta registrada com sucesso!");

            // 4. Teste de regra de negócio (Valor Negativo)
            System.out.println("\nTestando regra de negócio (valor negativo):");
            consultaController.registrar(1, LocalDate.now(), "Consulta errada", -50.0);

        } catch (Exception e) {
            System.err.println("Erro na operação: " + e.getMessage());
        }
    }
}