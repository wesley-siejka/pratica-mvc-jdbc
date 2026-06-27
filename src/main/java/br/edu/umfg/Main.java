package br.edu.umfg;

import br.edu.umfg.controller.*;

public class Main {
    public static void main(String[] args) {
        // Instanciando os controllers
        AlunoController alunoCtrl = new AlunoController();
        DisciplinaController discCtrl = new DisciplinaController();
        MatriculaController matCtrl = new MatriculaController();

        try {
            System.out.println("--- INICIANDO FLUXO: ESCOLA ---");

            // 1. Criando o Aluno
            alunoCtrl.salvar("João Silva", "joao@email.com");
            System.out.println("Aluno cadastrado com sucesso!");

            // 2. Criando a Disciplina
            discCtrl.salvar("Banco de Dados", 80);
            System.out.println("Disciplina cadastrada com sucesso!");

            // 3. Realizando a Matrícula
            // Supondo que o ID do aluno seja 1 e o da disciplina seja 1 (autoincrement do banco)
            matCtrl.matricular(1, 1);
            System.out.println("Matrícula realizada com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro na execução: " + e.getMessage());
            e.printStackTrace();
        }
    }
}